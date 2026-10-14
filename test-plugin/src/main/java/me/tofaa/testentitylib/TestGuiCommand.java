package me.tofaa.testentitylib;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import me.tofaa.entitylib.gui.Gui;
import me.tofaa.entitylib.gui.GuiButton;
import me.tofaa.entitylib.gui.GuiIcon;
import me.tofaa.entitylib.gui.GuiLabel;
import me.tofaa.entitylib.gui.GuiLayout;
import me.tofaa.entitylib.gui.GuiPanel;
import me.tofaa.entitylib.gui.GuiProgressBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestGuiCommand extends BukkitCommand {

    private final Map<UUID, Integer> clicks = new ConcurrentHashMap<>();
    private Gui gui;

    public TestGuiCommand() {
        super("testgui");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        Player player = (Player) commandSender;
        if (gui != null) {
            gui.remove();
            gui = null;
            if (strings.length > 0 && strings[0].equalsIgnoreCase("remove")) {
                return true;
            }
        }
        gui = new Gui();
        GuiPanel background = new GuiPanel(3.2, 2.2, 0xB0101018);
        GuiLabel title = new GuiLabel(Component.text("EntityLib GUI", NamedTextColor.GOLD));
        title.textScale(1.4).layer(1).at(0, 0.8);
        GuiLabel counter = new GuiLabel(Component.text("Clicks: 0"));
        counter.layer(1).at(0, 0.35);
        GuiProgressBar bar = new GuiProgressBar(2.4, 0.15);
        bar.layer(1).at(0, 0);
        GuiIcon icon = new GuiIcon(ItemStack.builder().type(ItemTypes.DIAMOND).build(), 0.4);
        icon.layer(1).at(-1.2, 0.8);

        GuiButton plus = new GuiButton(Component.text("+1", NamedTextColor.GREEN), 1, 0.4);
        GuiButton reset = new GuiButton(Component.text("Reset", NamedTextColor.RED), 1, 0.4);
        plus.layer(1);
        reset.layer(1);
        GuiLayout.row(0, -0.6, 0.2, plus, reset);
        plus.onClick((viewer, click) -> {
            int count = clicks.merge(viewer, 1, Integer::sum);
            counter.text(viewer, Component.text("Clicks: " + count + " (" + click + ")"));
            bar.progress((count % 11) / 10.0);
        });
        reset.onClick((viewer, click) -> {
            clicks.remove(viewer);
            counter.resetText(viewer);
            bar.progress(0);
        });

        gui.add(background, title, counter, bar, icon, plus, reset);
        gui.open(player.getUniqueId());
        gui.spawn(Gui.inFrontOf(SpigotConversionUtil.fromBukkitLocation(player.getEyeLocation()), 3));
        player.sendMessage("GUI opened, look at a button and click");
        return true;
    }

}
