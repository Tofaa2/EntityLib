package me.tofaa.entitylib.discord.listeners;

import com.google.auto.service.AutoService;
import me.tofaa.entitylib.discord.DiscordBot;
import me.tofaa.entitylib.discord.commands.Command;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

@AutoService(EventListener.class)
public class CommandListener implements EventListener {

    @Override
    public void onEvent(@NotNull GenericEvent genericEvent) {
        if (!(genericEvent instanceof SlashCommandInteractionEvent)) {
            return;
        }
        SlashCommandInteractionEvent event = (SlashCommandInteractionEvent) genericEvent;
        Command command = DiscordBot.instance().commands().stream()
                .filter(f -> f.name().equalsIgnoreCase(event.getName()))
                .findAny().orElse(null);
        if (command == null) {
            return;
        }
        command.handle(event.getInteraction());
    }
}
