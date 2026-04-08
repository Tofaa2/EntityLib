package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class NPCListenerManager {

    private static final List<Consumer<NPCInteractEvent>> leftClickHandlers = new ArrayList<>();
    private static final List<Consumer<NPCInteractEvent>> rightClickHandlers = new ArrayList<>();
    private static boolean registered = false;

    private NPCListenerManager() {
    }

    public static void register(org.bukkit.plugin.java.JavaPlugin plugin) {
        if (registered) return;
        registered = true;

        EntityLib.getApi().getPacketEvents().getEventManager().registerListener(new PacketListenerAbstract() {
            @Override
            public void onPacketReceive(PacketReceiveEvent event) {
                if (event.getPacketType() == PacketType.Play.Client.INTERACT_ENTITY) {
                    WrapperPlayClientInteractEntity packet = new WrapperPlayClientInteractEntity(event);
                    int entityId = packet.getEntityId();
                    User user = event.getUser();
                    
                    NPC npc = NPCRegistry.getByEntityId(entityId);
                    if (npc == null) return;
                    
                    boolean isLeftClick = packet.getAction() == WrapperPlayClientInteractEntity.InteractAction.ATTACK;
                    
                    NPCInteractEvent interactEvent = new NPCInteractEvent(npc, user.getUUID(), isLeftClick);
                    
                    if (isLeftClick) {
                        for (Consumer<NPCInteractEvent> handler : leftClickHandlers) {
                            handler.accept(interactEvent);
                        }
                    } else {
                        for (Consumer<NPCInteractEvent> handler : rightClickHandlers) {
                            handler.accept(interactEvent);
                        }
                    }
                }
            }
        });
    }

    public static void registerInteraction(
            Consumer<NPCInteractEvent> leftClick,
            Consumer<NPCInteractEvent> rightClick
    ) {
        if (leftClick != null) {
            leftClickHandlers.add(leftClick);
        }
        if (rightClick != null) {
            rightClickHandlers.add(rightClick);
        }
    }

    public static void unregisterAll() {
        leftClickHandlers.clear();
        rightClickHandlers.clear();
    }

    public static class NPCInteractEvent extends Event implements Cancellable {
        private static final HandlerList HANDLERS = new HandlerList();
        
        private final NPC npc;
        private final UUID playerId;
        private final boolean leftClick;
        private boolean cancelled = false;

        public NPCInteractEvent(NPC npc, UUID playerId, boolean leftClick) {
            this.npc = npc;
            this.playerId = playerId;
            this.leftClick = leftClick;
        }

        public @NotNull NPC getNPC() {
            return npc;
        }

        public @NotNull UUID getPlayerId() {
            return playerId;
        }

        public boolean isLeftClick() {
            return leftClick;
        }

        public boolean isRightClick() {
            return !leftClick;
        }

        public @Nullable org.bukkit.entity.Player getPlayer() {
            return org.bukkit.Bukkit.getPlayer(playerId);
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }

        @Override
        public void setCancelled(boolean cancelled) {
            this.cancelled = cancelled;
        }

        @Override
        public @NotNull HandlerList getHandlers() {
            return HANDLERS;
        }

        public static @NotNull HandlerList getHandlerList() {
            return HANDLERS;
        }
    }
}
