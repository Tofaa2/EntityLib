package me.tofaa.entitylib.discord.commands.impl;

import com.google.auto.service.AutoService;
import me.tofaa.entitylib.discord.commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.util.Arrays;
import java.util.List;

@AutoService(Command.class)
public class SendMessageCommand extends Command {

    public SendMessageCommand() {
        super(
                "sendmessage",
                "Send a message in a channel",
                Arrays.asList(
                        new OptionData(OptionType.STRING, "message", "The  message", true),
                        new OptionData(OptionType.STRING, "ping", "The type of ping to do", true)
                                .addChoice("Everyone", "everyone")
                                .addChoice("EntityLib", "elib")
                ),
                Permission.ADMINISTRATOR
        );
    }

    @Override
    public void handle(SlashCommandInteraction interaction) {
        String msg = interaction.getOption("message").getAsString();
        MessageCreateBuilder builder =new MessageCreateBuilder();
        builder.setContent(msg);

        String pingType = interaction.getOption("ping").getAsString().toLowerCase();
        switch (pingType) {
            case "elib": {
                builder =builder.mentionRoles(1304607456650985502L);
                break;
            }
            case "everyone": {
                builder =builder.mentionRoles(1197504277787201616L);
                break;
            }
            default: {}
        }
        interaction.getChannel().sendMessage(builder.build()).queue();;
        interaction.reply("Sent").setEphemeral(true).queue();
    }
}
