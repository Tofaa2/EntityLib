package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfoRemove;
import me.tofaa.entitylib.wrapper.WrapperEntity;
import me.tofaa.entitylib.wrapper.WrapperPlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

public class NPCPlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World playerWorld = player.getWorld();
        UUID playerId = player.getUniqueId();
        org.bukkit.Location playerLoc = player.getLocation();

        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;

            World npcWorld = npc.getWorld();
            if (npcWorld != null && npcWorld != playerWorld) continue;

            double viewDistance = npc.getOptions().getViewDistance();
            Location npcLoc = npc.getPosition();
            if (viewDistance > 0 && !isPlayerInRange(playerLoc, npcLoc, viewDistance)) continue;

            boolean isSitting = npc.getSittingEntity().isPresent();

            if (isSitting) {
                npc.getSittingEntity().ifPresent(sitting -> sitting.addViewer(playerId));
            }

            npc.getEntity().ifPresent(entity -> {
                entity.addViewer(playerId);
                if (entity instanceof me.tofaa.entitylib.wrapper.WrapperPlayer) {
                    npc.doStupidDogshitForOldClients(player);
                }
            });

            if (npc.getHologram().isPresent()) {
                npc.getHologram().get().addViewer(playerId);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;

            npc.getSittingEntity().ifPresent(sitting -> sitting.removeViewer(playerId));

            npc.getEntity().ifPresent(entity -> entity.removeViewer(playerId));

            if (npc.getHologram().isPresent()) {
                npc.getHologram().get().removeViewer(playerId);
            }
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled()) return;
        
        Player player = event.getPlayer();
        org.bukkit.World playerWorld = player.getWorld();
        UUID playerId = player.getUniqueId();
        org.bukkit.Location playerLoc = event.getTo();

        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;

            World npcWorld = npc.getWorld();
            if (npcWorld != null && npcWorld != playerWorld) continue;

            double viewDistance = npc.getOptions().getViewDistance();
            Location npcLoc = npc.getPosition();
            boolean inRange = viewDistance <= 0 || isPlayerInRange(playerLoc, npcLoc, viewDistance);

            boolean isSitting = npc.getSittingEntity().isPresent();
            
            if (isSitting) {
                npc.getSittingEntity().ifPresent(sitting -> {
                    if (inRange) {
                        if (!sitting.getViewers().contains(playerId)) {
                            sitting.addViewer(playerId);
                        }
                        npc.getEntity().ifPresent(entity -> {
                            if (!entity.getViewers().contains(playerId)) {
                                entity.addViewer(playerId);
                            }
                            if (entity instanceof me.tofaa.entitylib.wrapper.WrapperPlayer) {
                                npc.doStupidDogshitForOldClients(player);
                            }
                        });
                    } else {
                        if (sitting.getViewers().contains(playerId)) {
                            sitting.removeViewer(playerId);
                        }
                        npc.getEntity().ifPresent(entity -> {
                            if (entity.getViewers().contains(playerId)) {
                                entity.removeViewer(playerId);
                            }
                        });
                    }
                });
            } else {
                npc.getEntity().ifPresent(entity -> {
                    if (inRange) {
                        if (!entity.getViewers().contains(playerId)) {
                            entity.addViewer(playerId);
                        }
                        if (entity instanceof me.tofaa.entitylib.wrapper.WrapperPlayer) {
                            npc.doStupidDogshitForOldClients(player);
                        }
                    } else {
                        if (entity.getViewers().contains(playerId)) {
                            entity.removeViewer(playerId);
                        }
                    }
                });
            }

            npc.getHologram().ifPresent(hologram -> {
                if (inRange) {
                    if (!hologram.getEntity().getViewers().contains(playerId)) {
                        hologram.addViewer(playerId);
                    }
                } else {
                    if (hologram.getEntity().getViewers().contains(playerId)) {
                        hologram.removeViewer(playerId);
                    }
                }
            });
        }
    }

    private boolean isPlayerInRange(org.bukkit.Location playerLoc, Location npcLoc, double range) {
        double dx = playerLoc.getX() - npcLoc.getX();
        double dy = playerLoc.getY() - npcLoc.getY();
        double dz = playerLoc.getZ() - npcLoc.getZ();
        return (dx * dx + dy * dy + dz * dz) <= (range * range);
    }
}