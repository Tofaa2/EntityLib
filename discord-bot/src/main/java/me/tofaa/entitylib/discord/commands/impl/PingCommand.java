package me.tofaa.entitylib.discord.commands.impl;

import com.google.auto.service.AutoService;
import me.tofaa.entitylib.discord.commands.Command;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.util.Collections;

@AutoService(Command.class)
public class PingCommand extends Command {

    public PingCommand() {
        super("ping", "Ping command", Collections.emptyList(), null);
    }

    @Override
    public void handle(SlashCommandInteraction interaction) {
        interaction.reply("Pong").queue();
    }
}
