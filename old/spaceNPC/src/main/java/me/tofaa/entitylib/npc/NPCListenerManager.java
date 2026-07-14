package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientInteractEntity;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.npc.interactions.InteractionHandler;
import me.tofaa.entitylib.npc.interactions.InteractionType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class NPCListenerManager {

    private static final List<Consumer<NPCInteractEvent>> leftClickHandlers = new ArrayList<>();
    private static final List<Consumer<NPCInteractEvent>> rightClickHandlers = new ArrayList<>();
    private static final Set<UUID> playersHoldingShift = ConcurrentHashMap.newKeySet();
    private static boolean registered = false;

    private NPCListenerManager() {
    }

    public static void register(org.bukkit.plugin.java.JavaPlugin plugin) {
        if (registered) return;
        registered = true;

        EntityLib.getApi().getPacketEvents().getEventManager().registerListener(new PacketListenerAbstract() {
            @Override
            public void onPacketReceive(PacketReceiveEvent event) {
                UUID playerId = event.getUser().getUUID();

//                if (event.getPacketType() == PacketType.Play.Client.USE_ITEM) {
//                    WrapperPlayClientUseItem useItemPacket = new WrapperPlayClientUseItem(event);
//                    playersHoldingShift.add(playerId);
//                    useItemPacket.get
//                    handleInteraction(event, playerId, false, true);
//                    return;
//                }

                if (event.getPacketType() == PacketType.Play.Client.INTERACT_ENTITY) {
                    WrapperPlayClientInteractEntity packet = new WrapperPlayClientInteractEntity(event);
                    int entityId = packet.getEntityId();
                    User user = event.getUser();

                    NPC npc = NPCRegistry.getByEntityId(entityId);
                    if (npc == null) return;

                    boolean isLeftClick = packet.getAction() == WrapperPlayClientInteractEntity.InteractAction.ATTACK;
                    boolean isShift = playersHoldingShift.contains(playerId);

                    if (isLeftClick) {
                        handleInteraction(event, playerId, isLeftClick, isShift, npc);
                    } else {
                        handleInteraction(event, playerId, isLeftClick, isShift, npc);
                    }
                }
            }
        });

        EntityLib.getApi().getPacketEvents().getEventManager().registerListener(new PacketListenerAbstract() {
            @Override
            public void onPacketReceive(PacketReceiveEvent event) {
                if (event.getPacketType() == PacketType.Play.Client.CHAT_MESSAGE || 
                    event.getPacketType() == PacketType.Play.Client.CLIENT_SETTINGS ||
                    event.getPacketType() == PacketType.Play.Client.PLAYER_ABILITIES ||
                    event.getPacketType() == PacketType.Play.Client.PLAYER_DIGGING ||
                    event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION ||
                    event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION_AND_ROTATION ||
                    event.getPacketType() == PacketType.Play.Client.PLAYER_ROTATION ||
                    event.getPacketType() == PacketType.Play.Client.HELD_ITEM_CHANGE) {
                    UUID playerId = event.getUser().getUUID();
                    playersHoldingShift.remove(playerId);
                }
            }
        });
    }

    private static void handleInteraction(
            PacketReceiveEvent event,
            UUID playerId,
            boolean isLeftClick,
            boolean isShift,
            NPC npc
    ) {
//        WrapperPlayClientInteractEntity packet = new WrapperPlayClientInteractEntity(event);
//        int entityId = packet.getEntityId();
//        NPC npc = NPCRegistry.getByEntityId(npcId);
//        if (npc == null) return;

        InteractionType interactionType = getInteractionType(isLeftClick, isShift);

        Player player = event.getPlayer();
        InteractionHandler.handleInteraction(npc, player, interactionType);

        NPCInteractEvent interactEvent = new NPCInteractEvent(npc, playerId, isLeftClick, isShift);

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

    private static InteractionType getInteractionType(boolean isLeftClick, boolean isShift) {
        if (isLeftClick && isShift) {
            return InteractionType.SHIFT_LEFT_CLICK;
        } else if (isLeftClick) {
            return InteractionType.LEFT_CLICK;
        } else if (isShift) {
            return InteractionType.SHIFT_RIGHT_CLICK;
        } else {
            return InteractionType.RIGHT_CLICK;
        }
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
        private final boolean shift;
        private boolean cancelled = false;

        public NPCInteractEvent(NPC npc, UUID playerId, boolean leftClick, boolean shift) {
            this.npc = npc;
            this.playerId = playerId;
            this.leftClick = leftClick;
            this.shift = shift;
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

        public boolean isShift() {
            return shift;
        }

        public @Nullable Player getPlayer() {
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
