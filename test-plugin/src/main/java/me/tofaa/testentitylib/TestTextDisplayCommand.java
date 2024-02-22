package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestTextDisplayCommand extends BukkitCommand {

    private WrapperEntity e;

    public TestTextDisplayCommand() {
        super("textdisplay");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (e == null) {
            e = EntityLib.getApi().createEntity(EntityTypes.TEXT_DISPLAY);
            if (e == null) {
                player.sendMessage("Failed to spawn entity");
                return true;
            }
            e.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
            e.addViewer(player.getUniqueId());
            player.sendMessage("Spawned");
        }
        String msg = String.join(" ", strings);
        TextDisplayMeta meta = (TextDisplayMeta) e.getEntityMeta();
        meta.setText(Component.text(msg));
        player.sendMessage("Set text to: " + msg);
        return true;
    }
}
