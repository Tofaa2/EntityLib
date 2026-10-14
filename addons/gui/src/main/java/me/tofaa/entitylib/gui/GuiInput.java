package me.tofaa.entitylib.gui;

import com.github.retrooper.packetevents.PacketEventsAPI;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketListenerCommon;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerFlying;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.display.math.Vec3;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class GuiInput {

    private static final double EYE_HEIGHT = 1.62;
    private static final long CLICK_INTERVAL_NANOS = 50_000_000L;

    private static final class View {
        volatile double x;
        volatile double y;
        volatile double z;
        volatile float yaw;
        volatile float pitch;
        volatile boolean positioned;
        volatile long lastClick;
    }

    private static final List<Gui> GUIS = new CopyOnWriteArrayList<>();
    private static final Map<UUID, View> VIEWS = new ConcurrentHashMap<>();
    private static PacketEventsAPI<?> registeredWith;
    private static PacketListenerCommon listener;

    private GuiInput() {
    }

    static synchronized void register(Gui gui) {
        if (!GUIS.contains(gui)) {
            GUIS.add(gui);
        }
        PacketEventsAPI<?> packetEvents = EntityLib.get().getConfig().getPacketEvents();
        if (registeredWith == packetEvents) {
            return;
        }
        if (registeredWith != null && listener != null) {
            registeredWith.getEventManager().unregisterListener(listener);
        }
        registeredWith = packetEvents;
        listener = packetEvents.getEventManager().registerListener(new Listener());
    }

    static synchronized void unregister(Gui gui) {
        GUIS.remove(gui);
        if (GUIS.isEmpty() && registeredWith != null && listener != null) {
            registeredWith.getEventManager().unregisterListener(listener);
            registeredWith = null;
            listener = null;
            VIEWS.clear();
        }
    }

    private static final class Listener extends PacketListenerAbstract {

        @Override
        public void onPacketReceive(PacketReceiveEvent event) {
            UUID viewer = event.getUser().getUUID();
            if (viewer == null || GUIS.isEmpty()) {
                return;
            }
            PacketTypeCommon type = event.getPacketType();
            if (WrapperPlayClientPlayerFlying.isFlying(type)) {
                if (!viewing(viewer)) {
                    return;
                }
                WrapperPlayClientPlayerFlying packet = new WrapperPlayClientPlayerFlying(event);
                View view = VIEWS.computeIfAbsent(viewer, key -> new View());
                Location location = packet.getLocation();
                if (packet.hasPositionChanged()) {
                    view.x = location.getX();
                    view.y = location.getY();
                    view.z = location.getZ();
                    view.positioned = true;
                }
                if (packet.hasRotationChanged()) {
                    view.yaw = location.getYaw();
                    view.pitch = location.getPitch();
                }
                if (view.positioned) {
                    look(viewer, view);
                }
            } else if (type == PacketType.Play.Client.ANIMATION) {
                click(viewer, GuiClick.LEFT);
            } else if (type == PacketType.Play.Client.USE_ITEM || type == PacketType.Play.Client.PLAYER_BLOCK_PLACEMENT) {
                click(viewer, GuiClick.RIGHT);
            }
        }

        @Override
        public void onUserDisconnect(UserDisconnectEvent event) {
            UUID viewer = event.getUser().getUUID();
            if (viewer == null) {
                return;
            }
            VIEWS.remove(viewer);
            for (Gui gui : GUIS) {
                gui.forget(viewer);
            }
        }

    }

    private static boolean viewing(UUID viewer) {
        for (Gui gui : GUIS) {
            if (gui.getViewers().contains(viewer)) {
                return true;
            }
        }
        return false;
    }

    private static void look(UUID viewer, View view) {
        Vec3 eye = new Vec3(view.x, view.y + EYE_HEIGHT, view.z);
        double yaw = Math.toRadians(view.yaw);
        double pitch = Math.toRadians(view.pitch);
        Vec3 direction = new Vec3(-Math.sin(yaw) * Math.cos(pitch), -Math.sin(pitch), Math.cos(yaw) * Math.cos(pitch));
        for (Gui gui : GUIS) {
            if (gui.getViewers().contains(viewer)) {
                gui.look(viewer, eye, direction);
            }
        }
    }

    private static void click(UUID viewer, GuiClick click) {
        View view = VIEWS.get(viewer);
        if (view == null) {
            return;
        }
        long now = System.nanoTime();
        if (now - view.lastClick < CLICK_INTERVAL_NANOS) {
            return;
        }
        view.lastClick = now;
        for (Gui gui : GUIS) {
            if (gui.getViewers().contains(viewer)) {
                gui.click(viewer, click);
            }
        }
    }

}
