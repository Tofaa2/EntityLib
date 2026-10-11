package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.meta.MetaFields;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

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
            e = new WrapperLivingEntity(EntityTypes.PIG);
            e.addViewer(player.getUniqueId());
            e.spawn(SpigotConversionUtil.fromBukkitLocation(player.getLocation()));
            player.sendMessage("Spawned");
        }
        String msg = String.join(" ", strings);
        e.setMetadata(MetaFields.Entity.CUSTOM_NAME_VISIBLE, true);
        e.setMetadata(MetaFields.Entity.CUSTOM_NAME, Optional.of(Component.text(msg)));
        e.setFlag(MetaFields.Entity.GLOWING, true);
        player.sendMessage("Set text to: " + msg);
        return true;
    }

}
