package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoUpdate;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.spigot.ExtraConversionUtil;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TestPlayerCommand extends BukkitCommand {

    private WrapperPlayer p;
    public TestPlayerCommand() {
        super("testplayer");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length != 1) {
            player.sendMessage("Usage: /testplayer <spawn|hello|ping|gamemode|displayname|tablist|remove>");
            return false;
        }
        String arg = strings[0].toLowerCase();
        switch (arg) {
            case "spawn":
                UserProfile profile = new UserProfile(UUID.randomUUID(), "randomname", new ArrayList<>());
                p = new WrapperPlayer(profile, EntityLib.getPlatform().getEntityIdProvider().provide(profile.getUUID(), EntityTypes.PLAYER));
                p.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
                p.addViewer(player.getUniqueId());
                ItemStack stack = ItemStack.builder().type(ItemTypes.DIAMOND_BOOTS).build();
                p.getEquipment().setBoots(stack);
                break;
            case "texture":
                p.setTextureProperties(ExtraConversionUtil.getProfileFromBukkitPlayer(player).getTextureProperties());
                player.sendMessage("texture");
                break;
            case "ping":
                p.setLatency(1000);
                player.sendMessage("Pong");
                break;
            case "gamemode":
                p.setGameMode(GameMode.CREATIVE);
                player.sendMessage("Gamemode set to creative");
                break;
            case "displayname":
                p.setDisplayName(Component.text("Hello"));
                player.sendMessage("Display name set to Hello");
                break;
            case "tablist":
                p.setInTablist(!p.isInTablist());
                player.sendMessage("Tablist " + (p.isInTablist() ? "enabled" : "disabled"));
                break;
            case "remove":
                p.remove();
                player.sendMessage("Entity removed");
                break;
        }
        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if (args.length == 1) {
            return Arrays.asList("spawn", "texture", "ping", "gamemode", "displayname", "tablist", "remove", "sneak");
        }
        return Collections.emptyList();
    }
}
