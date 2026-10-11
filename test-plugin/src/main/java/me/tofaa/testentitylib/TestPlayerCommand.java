package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.extras.skin.SkinFetcher;
import me.tofaa.entitylib.spigot.ExtraConversionUtil;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestPlayerCommand extends BukkitCommand {

    private WrapperPlayer p;
    private SkinFetcher sf;

    public TestPlayerCommand() {
        super("testplayer");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (strings.length < 1) {
            player.sendMessage("Usage: /testplayer <spawn|skin|texture|ping|gamemode|displayname|tablist|remove|hidearmor>");
            return false;
        }
        String arg = strings[0].toLowerCase();
        if (p == null && !arg.equals("spawn")) {
            player.sendMessage("Spawn an entity first");
            return false;
        }
        switch (arg) {
            case "spawn":
                UserProfile profile = new UserProfile(UUID.randomUUID(), "randomname", new ArrayList<>());
                p = new WrapperPlayer(profile);
                p.addViewer(player.getUniqueId());
                p.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
                p.getEquipment().setBoots(ItemStack.builder().type(ItemTypes.DIAMOND_BOOTS).build());
                player.sendMessage("Entity spawned");
                break;
            case "skin":
                if (strings.length < 2) {
                    player.sendMessage("Usage: /testplayer skin <name>");
                    return false;
                }
                if (sf == null) {
                    sf = SkinFetcher.builder()
                            .cached()
                            .build();
                }
                p.setTextureProperties(sf.getSkin(strings[1]));
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
                p = null;
                player.sendMessage("Entity removed");
                break;
            case "hidearmor":
                p.getEquipment().setNotifyChanges(false);
                p.getEquipment().clearAll();
                p.getEquipment().setNotifyChanges(true);
                break;
            default:
                break;
        }
        return true;
    }

    @NotNull
    @Override
    public List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        if (args.length == 1) {
            return Arrays.asList("spawn", "skin", "texture", "ping", "gamemode", "displayname", "tablist", "remove", "hidearmor");
        }
        return Collections.emptyList();
    }

}
