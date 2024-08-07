package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.extras.skin.SkinFetcher;
import me.tofaa.entitylib.spigot.ExtraConversionUtil;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TestPlayerCommand extends BukkitCommand {


    private static final char UNICODE_EMPTY = '\u2800';

    private WrapperPlayer p;
    private SkinFetcher sf;
    public TestPlayerCommand() {
        super("testplayer");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (p != null) {
            p.setInTablist(!p.isInTablist());
            return true;
        }

        p = new WrapperPlayer(new UserProfile(UUID.randomUUID(), "\u2800"), EntityLib.getPlatform().getEntityIdProvider().provide(UUID.randomUUID(), EntityTypes.PLAYER));
        p.setInTablist(true);
        p.setTextureProperties(ExtraConversionUtil.getProfileFromBukkitPlayer(player).getTextureProperties());
        p.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
        p.addViewer(player.getUniqueId());
        player.sendMessage("Entity spawned");
        return true;
    }

    private boolean legacyProcess(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length < 1) {
            player.sendMessage("Usage: /testplayer <spawn|hello|ping|gamemode|displayname|tablist|remove>");
            return false;
        }
        String arg = strings[0].toLowerCase();
        switch (arg) {
            case "skin":
                String input = strings[1];
                if (p == null) {
                    player.sendMessage("Spawn an entity first");
                    return false;
                }
                if (sf == null) {
                    sf = SkinFetcher.builder()
                            .cached()
                            .build();
                }
                p.setTextureProperties(sf.getSkin(input));
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
            case "hidearmor":
                p.getEquipment().setNotifyChanges(false);
                p.getEquipment().setBoots(null);
                p.getEquipment().setChestplate(null);
                p.getEquipment().setHelmet(null);
                p.getEquipment().setLeggings(null);
                p.getEquipment().setMainHand(null);
                p.getEquipment().setOffhand(null);
                p.getEquipment().setNotifyChanges(true);
        }
        return true;
    }


    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if (args.length == 1) {
            return Arrays.asList("spawn", "texture", "ping", "gamemode", "displayname", "tablist", "remove", "sneak", "hidearmor");
        }
        return Collections.emptyList();
    }
}
