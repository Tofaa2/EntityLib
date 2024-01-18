package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.meta.types.DisplayMeta;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TestDisplayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.TEXT_DISPLAY);
        TextDisplayMeta meta = (TextDisplayMeta) e.getMeta();
        meta.setText(Component.text("Hello World!", NamedTextColor.GOLD));
        meta.setBillboardConstraints(DisplayMeta.BillboardConstraints.CENTER);
        e.addViewer((player.getUniqueId()));
        e.spawn(SpigotConversionUtil.fromBukkitLocation((player.getLocation().clone().add(0, 2, 0))));
        return true;
    }
}
