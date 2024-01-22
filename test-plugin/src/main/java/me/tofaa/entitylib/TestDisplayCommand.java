package me.tofaa.entitylib;

import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.util.Vector3f;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.entity.WrapperEntity;
import me.tofaa.entitylib.meta.display.BlockDisplayMeta;
import me.tofaa.entitylib.meta.display.ItemDisplayMeta;
import me.tofaa.entitylib.meta.display.TextDisplayMeta;
import me.tofaa.entitylib.meta.types.DisplayMeta;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestDisplayCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) return false;
        String type = strings[0];
        Player player = (Player) commandSender;
        switch (type) {
            case "block":
                block(player);
                break;
            case "text":
                text(player);
                break;
            case "item":
                item(player);
                break;
        }
        return false;
    }



    private void block(Player player) {
        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.BLOCK_DISPLAY);
        BlockDisplayMeta meta = (BlockDisplayMeta) e.getMeta();
        meta.setHasGlowingEffect(true);
        meta.setBlockId(SpigotConversionUtil.fromBukkitBlockData(Material.ACACIA_LOG.createBlockData()).getGlobalId());
        meta.setBillboardConstraints(DisplayMeta.BillboardConstraints.CENTER);
        meta.setScale(new Vector3f(2, 2, 2));
        e.addViewer(player.getUniqueId());
        e.spawn(fromPlayer(player));
    }

    private void text(Player player) {
        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.TEXT_DISPLAY);
        TextDisplayMeta meta = (TextDisplayMeta) e.getMeta();
        meta.setHasGlowingEffect(true);
        meta.setText(Component.text("Hello World!"));
        meta.setBillboardConstraints(DisplayMeta.BillboardConstraints.CENTER);
        meta.setTranslation(new Vector3f(4.0f, 0.0f, 0.0f));
        meta.setScale(new Vector3f(2, 2, 2));
        e.addViewer(player.getUniqueId());
        e.spawn(fromPlayer(player));
    }

    private void item(Player player) {
        WrapperEntity e = EntityLib.createEntity(UUID.randomUUID(), EntityTypes.ITEM_DISPLAY);
        ItemDisplayMeta meta = (ItemDisplayMeta) e.getMeta();
        meta.setDisplayType(ItemDisplayMeta.DisplayType.FIRST_PERSON_LEFT_HAND);
        meta.setItem(ItemStack.builder()
                .type(ItemTypes.ACACIA_BOAT).build()
        );
        e.addViewer(player.getUniqueId());
        e.spawn(fromPlayer(player));
    }

    private static Location fromPlayer(Player player) {
        return new Location(player.getLocation().getX(), player.getLocation().getY() + 2, player.getLocation().getZ(), 0f, 0f);
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return strings.length == 1 ? Arrays.asList("block", "text", "item") : null;
    }
}
