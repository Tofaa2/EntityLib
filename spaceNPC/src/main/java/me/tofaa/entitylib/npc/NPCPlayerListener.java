package me.tofaa.entitylib.npc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class NPCPlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        org.bukkit.World playerWorld = event.getPlayer().getWorld();
        for (NPC npc : NPCRegistry.getAll()) {
            if (!npc.isSpawned() || !npc.getEntity().isPresent()) continue;
            
            org.bukkit.World npcWorld = npc.getWorld();
            if (npcWorld != null && npcWorld != playerWorld) continue;

            npc.getEntity().get().addViewer(event.getPlayer().getUniqueId());
            
            if (npc.getHologram().isPresent()) {
                npc.getHologram().get().addViewer(event.getPlayer().getUniqueId());
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        for (NPC npc : NPCRegistry.getAll()) {
            if (npc.isSpawned() && npc.getEntity().isPresent()) {
                npc.getEntity().get().removeViewer(event.getPlayer().getUniqueId());
                
                if (npc.getHologram().isPresent()) {
                    npc.getHologram().get().removeViewer(event.getPlayer().getUniqueId());
                }
            }
        }
    }
}