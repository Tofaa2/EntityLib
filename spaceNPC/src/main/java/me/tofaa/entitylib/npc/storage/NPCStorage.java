package me.tofaa.entitylib.npc.storage;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.npc.NPC;
import me.tofaa.entitylib.npc.NPCOptions;
import me.tofaa.entitylib.npc.NPCRegistry;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.skin.NPCSkin;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class NPCStorage {

    private static final String NPC_FOLDER = "npcs";

    private final JavaPlugin plugin;
    private final File npcFolder;

    public NPCStorage(JavaPlugin plugin) {
        this.plugin = plugin;
        this.npcFolder = new File(plugin.getDataFolder(), NPC_FOLDER);
        if (!npcFolder.exists()) {
            npcFolder.mkdirs();
        }
    }

    public void saveNPC(NPC npc) {
        File file = new File(npcFolder, npc.getId() + ".yml");
        YamlConfiguration config = new YamlConfiguration();

        config.set("id", npc.getId());
        config.set("entityType", npc.getEntityType().getName().toString());
        config.set("name", npc.getName());
        config.set("world", npc.getWorldName());
        config.set("x", npc.getPosition().getX());
        config.set("y", npc.getPosition().getY());
        config.set("z", npc.getPosition().getZ());
        config.set("yaw", npc.getPosition().getYaw());
        config.set("pitch", npc.getPosition().getPitch());

        NPCOptions opts = npc.getOptions();
        config.set("options.displayName", opts.getDisplayName() != null ? GsonComponentSerializer.gson().serialize(opts.getDisplayName()) : null);
        config.set("options.showNameTag", opts.isShowNameTag());
        config.set("options.lookAtPlayers", opts.isLookAtPlayers());
        config.set("options.lookAtPlayersPerPlayer", opts.isLookAtPlayersPerPlayer());
        config.set("options.lookAtPath", opts.isLookAtPath());
        config.set("options.collides", opts.isCollides());
        config.set("options.gravity", opts.isGravity());
        config.set("options.invulnerable", opts.isInvulnerable());
        config.set("options.silent", opts.isSilent());
        config.set("options.permanentlyVisible", opts.isPermanentlyVisible());
        config.set("options.viewDistance", opts.getViewDistance());

        NPCPath path = npc.getPath();
        config.set("path.started", path.isStarted());
        config.set("path.looping", path.isLooping());
        config.set("path.speed", path.getSpeed());
        
        if (path.getWaypointCount() > 0) {
            for (int i = 0; i < path.getWaypoints().size(); i++) {
                Location wp = path.getWaypoints().get(i);
                config.set("path.waypoints." + i + ".x", wp.getX());
                config.set("path.waypoints." + i + ".y", wp.getY());
                config.set("path.waypoints." + i + ".z", wp.getZ());
                config.set("path.waypoints." + i + ".yaw", wp.getYaw());
                config.set("path.waypoints." + i + ".pitch", wp.getPitch());
            }
        }

        if (npc.getSkin() != null) {
            config.set("skin.texture", npc.getSkin().getTexture());
            config.set("skin.signature", npc.getSkin().getSignature());
        }

        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().warning("Failed to save NPC " + npc.getId() + ": " + e.getMessage());
        }
    }

    public void deleteNPC(String npcId) {
        File file = new File(npcFolder, npcId + ".yml");
        if (file.exists()) {
            file.delete();
        }
    }

    public void loadAllNPCs() {
        File[] files = npcFolder.listFiles((dir, name) -> name.endsWith(".yml"));
        if (files == null) return;

        for (File file : files) {
            loadNPC(file);
        }
    }

    private EntityType getEntityType(String name) {
        return EntityTypes.getByName(name.toLowerCase());
    }

    private void loadNPC(File file) {
        try {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            String id = config.getString("id");
            String entityTypeStr = config.getString("entityType");
            String name = config.getString("name");
            double x = config.getDouble("x");
            double y = config.getDouble("y");
            double z = config.getDouble("z");
            float yaw = (float) config.getDouble("yaw");
            float pitch = (float) config.getDouble("pitch");

            EntityType entityType = getEntityType(entityTypeStr);
            if (entityType == null) {
                plugin.getLogger().warning("Invalid entity type " + entityTypeStr + " in " + file.getName());
                return;
            }

            NPC npc = new NPC(id, entityType);
            npc.setName(name);
            npc.setWorldName(config.getString("world", "world"));

            Location loc = new Location(x, y, z, yaw, pitch);
            npc.setPosition(loc);

            if (config.contains("options")) {
                NPCOptions opts = npc.getOptions();
                opts.showNameTag(config.getBoolean("options.showNameTag", true));
                opts.lookAtPlayers(config.getBoolean("options.lookAtPlayers", true));
                opts.lookAtPlayersPerPlayer(config.getBoolean("options.lookAtPlayersPerPlayer", false));
                opts.lookAtPath(config.getBoolean("options.lookAtPath", true));
                opts.collides(config.getBoolean("options.collides", true));
                opts.gravity(config.getBoolean("options.gravity", true));
                opts.invulnerable(config.getBoolean("options.invulnerable", false));
                opts.silent(config.getBoolean("options.silent", false));
                opts.permanentlyVisible(config.getBoolean("options.permanentlyVisible", false));
                opts.viewDistance(config.getDouble("options.viewDistance", 128.0));

                if (config.contains("options.displayName") && config.getString("options.displayName") != null) {
                    opts.displayName(GsonComponentSerializer.gson().deserialize(config.getString("options.displayName")));
                }
            }

            NPCPath path = npc.getPath();
            if (config.contains("path")) {
                path.setLooping(config.getBoolean("path.looping", true));
                path.setSpeed(config.getDouble("path.speed", 4.0));
                
                if (config.contains("path.waypoints")) {
                    org.bukkit.configuration.ConfigurationSection waypointsSection = config.getConfigurationSection("path.waypoints");
                    if (waypointsSection != null) {
                        for (String key : waypointsSection.getKeys(false)) {
                            double wx = waypointsSection.getDouble(key + ".x");
                            double wy = waypointsSection.getDouble(key + ".y");
                            double wz = waypointsSection.getDouble(key + ".z");
                            float wyaw = (float) waypointsSection.getDouble(key + ".yaw", 0);
                            float wpitch = (float) waypointsSection.getDouble(key + ".pitch", 0);
                            path.addWaypoint(new Location(wx, wy, wz, wyaw, wpitch));
                        }
                    }
                }
                
                boolean started = config.getBoolean("path.started", false);
                if (started && path.getWaypointCount() > 0) {
                    path.setStarted(true);
                    NPCRegistry.register(npc);
                    npc.spawn(loc);
                    me.tofaa.entitylib.npc.NPCMovement.startPathFollowing(npc);
                    return;
                }
            }

            if (config.contains("skin")) {
                String texture = config.getString("skin.texture");
                String signature = config.getString("skin.signature");
                if (texture != null) {
                    npc.setSkin(new NPCSkin(texture, signature));
                }
            }

            NPCRegistry.register(npc);
            npc.spawn(loc);

            plugin.getLogger().info("Loaded NPC: " + id);
        } catch (Exception e) {
            plugin.getLogger().warning("Failed to load NPC from " + file.getName() + ": " + e.getMessage());
        }
    }

    public void saveAll() {
        for (NPC npc : NPCRegistry.getAll()) {
            saveNPC(npc);
        }
    }
}
