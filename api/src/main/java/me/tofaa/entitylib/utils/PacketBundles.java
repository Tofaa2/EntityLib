package me.tofaa.entitylib.utils;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerBundle;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.EntityLibPlatform;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public final class PacketBundles {

    public static final int BUNDLE_PROTOCOL = 762;

    private PacketBundles() {
    }

    public static void send(@NotNull UUID user, @NotNull List<? extends PacketWrapper<?>> packets) {
        if (packets.isEmpty()) {
            return;
        }
        EntityLibPlatform platform = EntityLib.get().getPlatform();
        send(user, platform.getProtocolVersion(user), packets);
    }

    public static void send(@NotNull UUID user, int protocolVersion, @NotNull List<? extends PacketWrapper<?>> packets) {
        EntityLibPlatform platform = EntityLib.get().getPlatform();
        boolean bundle = packets.size() > 1 && protocolVersion >= BUNDLE_PROTOCOL
            && EntityLib.get().getConfig().shouldBundlePackets();
        if (bundle) {
            platform.sendPacket(user, new WrapperPlayServerBundle());
        }
        for (PacketWrapper<?> packet : packets) {
            platform.sendPacket(user, packet);
        }
        if (bundle) {
            platform.sendPacket(user, new WrapperPlayServerBundle());
        }
    }

}
