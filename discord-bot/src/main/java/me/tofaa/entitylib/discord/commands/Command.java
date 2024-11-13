package me.tofaa.entitylib.discord.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public abstract class Command {

    private final String name;
    private final String description;
    private final Collection<OptionData> options;
    private final Permission permission;

    public Command(String name, String description, Collection<OptionData> options, @Nullable Permission permission) {
        this.name = name;
        this.description = description;
        this.options = options;
        this.permission = permission;
    }

    public Permission permission() {
        return permission;
    }

    public boolean hasPermission() {
        return permission != null;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public Collection<OptionData> options() {
        return options;
    }

    public abstract void handle(SlashCommandInteraction interaction);

}
