package me.tofaa.entitylib.discord;

import me.tofaa.entitylib.discord.commands.Command;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class DiscordBot {

    public static Logger LOGGER = LoggerFactory.getLogger(DiscordBot.class);

    private static DiscordBot instance;
    public static DiscordBot instance() {
        return instance;
    }

    private final JDA discord;
    private final Set<Command> commands;

    DiscordBot(String[] args) {
        instance = this;
        if (args.length == 0) throw new RuntimeException("No token specified, use --token=token args");
        String token = args[0].replaceFirst("--token=", "");
        discord = JDABuilder.create(token, GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS)).build();

        this.commands = ConcurrentHashMap.newKeySet();
    }


    private void loadCommands() {
        ServiceLoader<Command> commands = ServiceLoader.load(Command.class);
        List<CommandData> data = new ArrayList<>();
        for (Command command : commands) {
            SlashCommandData cmd = Commands.slash(command.name(), command.description());
            if (command.hasPermission()) {
                cmd.setDefaultPermissions(DefaultMemberPermissions.enabledFor(command.permission()));
            }
            command.options().forEach(option -> {
                cmd.addOption(option.getType(), option.getName(), option.getDescription(), option.isRequired(), option.isAutoComplete());
            });
            data.add(cmd);
            LOGGER.info("Loaded command {}", command.name());
            this.commands.add(command);
        }
        discord.updateCommands().addCommands(data).queue();
    }

    private void loadEvents() {
        ServiceLoader<EventListener> loader = ServiceLoader.load(EventListener.class);
        for (EventListener listener : loader) {
            discord.getEventManager().register(listener);
            LOGGER.info("Loaded event listener {}", listener.getClass().getSimpleName());
        }
    }

    private void start() throws InterruptedException {
        discord.awaitReady();
        loadCommands();
        loadEvents();
    }


    public Set<Command> commands() {
        return commands;
    }

    public JDA discord() {
        return discord;
    }

    public static void main(String[] args) throws InterruptedException {
        DiscordBot bot = new DiscordBot(args);
        bot.start();
    }

}
