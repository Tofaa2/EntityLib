package me.tofaa.entitylib;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.player.InteractionHand;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerCloseWindow;
import me.tofaa.entitylib.entity.EntityInteractionProcessor;
import me.tofaa.entitylib.entity.WrapperEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class EntityLibPlugin extends JavaPlugin {

    static EntityLibPlugin instance;

    @Override
    public void onEnable() {
        EntityLib.init(PacketEvents.getAPI());
        EntityLib.enableEntityInteractions();
        EntityLib.setInteractionProcessor((entity, action, hand, user) -> user.sendMessage("Hello World"));
        getCommand("testapi").setExecutor(new TestCommand());
        getCommand("testentity").setExecutor(new TestEntityCommand());
        instance = this;
    }
}
