package me.tofaa.entitylib.npc.command;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.world.Location;
import me.tofaa.entitylib.extras.skin.SkinFetcher;
import me.tofaa.entitylib.movement.MovementEngine.MovementSettings;
import me.tofaa.entitylib.movement.MovementEngine.PathfindSettings;
import me.tofaa.entitylib.npc.NPC;
import me.tofaa.entitylib.npc.NPCMovement;
import me.tofaa.entitylib.npc.NPCOptions;
import me.tofaa.entitylib.npc.NPCRegistry;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.skin.NPCSkin;
import me.tofaa.entitylib.npc.storage.NPCStorage;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NPCCommand implements CommandExecutor, TabCompleter {

    private final NPCStorage storage;
    private final SkinFetcher skinFetcher;

    public NPCCommand(NPCStorage storage, SkinFetcher skinFetcher) {
        this.storage = storage;
        this.skinFetcher = skinFetcher;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        if (args.length == 0) {
            sendHelp(player);
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "create" -> handleCreate(player, args);
            case "remove" -> handleRemove(player, args);
            case "list" -> handleList(player);
            case "teleport", "tp" -> handleTeleport(player, args);
            case "name" -> handleName(player, args);
            case "skin" -> handleSkin(player, args);
            case "type" -> handleType(player, args);
            case "move" -> handleMove(player, args);
            case "walk" -> handleWalk(player, args);
            case "stop" -> handleStop(player, args);
            case "path" -> handlePath(player, args);
            case "options" -> handleOptions(player, args);
            default -> sendHelp(player);
        }

        return true;
    }

    private void handleCreate(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc create <id> <entityType> [name]");
            return;
        }

        String id = args[1];
        String entityTypeStr = args[2].toLowerCase();

        if (NPCRegistry.get(id) != null) {
            player.sendMessage("NPC with id '" + id + "' already exists");
            return;
        }

        EntityType entityType = getEntityType(entityTypeStr);
        if (entityType == null) {
            player.sendMessage("Invalid entity type: " + entityTypeStr);
            return;
        }

        String name = args.length >= 4 ? args[3] : id;

        NPC npc = new NPC(id, entityType);
        npc.setName(name);
        npc.setWorldName(player.getLocation().getWorld().getName());

        Location loc = new Location(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(),
                player.getLocation().getYaw(), player.getLocation().getPitch());

        NPCRegistry.register(npc);
        npc.spawn(loc);
        storage.saveNPC(npc);

        player.sendMessage("Created NPC '" + id + "' with entity type " + entityTypeStr);
    }

    private EntityType getEntityType(String name) {
        return EntityTypes.getByName(name.toLowerCase());
    }

    private void handleRemove(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Usage: /npc remove <id>");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        npc.remove();
        storage.deleteNPC(id);

        player.sendMessage("Removed NPC '" + id + "'");
    }

    private void handleList(Player player) {
        List<NPC> npcs = new java.util.ArrayList<>(NPCRegistry.getAll());

        if (npcs.isEmpty()) {
            player.sendMessage("No NPCs exist");
            return;
        }

        player.sendMessage("NPCs (" + npcs.size() + "):");
        for (NPC npc : npcs) {
            player.sendMessage("  - " + npc.getId() + " (" + npc.getEntityType() + ") at " +
                    (int) npc.getPosition().getX() + ", " + (int) npc.getPosition().getY() + ", " + (int) npc.getPosition().getZ());
        }
    }

    private void handleTeleport(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Usage: /npc teleport <id>");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        Location loc = npc.getPosition();
        player.teleport(new org.bukkit.Location(
                player.getWorld(),
                loc.getX(), loc.getY(), loc.getZ(),
                loc.getYaw(), loc.getPitch()
        ));

        player.sendMessage("Teleported to NPC '" + id + "'");
    }

    private void handleName(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc name <id> <name>");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        String name = args[2];
        npc.setName(name);
        storage.saveNPC(npc);

        player.sendMessage("Set name of NPC '" + id + "' to '" + name + "'");
    }

    private void handleSkin(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc skin <id> <playerName>");
            return;
        }

        String id = args[1];
        String playerName = args[2];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        player.sendMessage("Fetching skin for " + playerName + "...");

        List<TextureProperty> skins = skinFetcher.getSkin(playerName);
        if (skins.isEmpty()) {
            player.sendMessage("Failed to fetch skin for " + playerName);
            return;
        }

        TextureProperty skin = skins.getFirst();
        npc.setSkin(new NPCSkin(skin.getValue(), skin.getSignature()));

        if (npc.isSpawned()) {
            npc.despawn();
            npc.spawn(npc.getPosition());
        }

        storage.saveNPC(npc);
        player.sendMessage("Set skin of NPC '" + id + "' to " + playerName);
    }

    private void handleType(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc type <id> <entityType>");
            return;
        }

        String id = args[1];
        String entityTypeStr = args[2].toUpperCase();
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        EntityType entityType = getEntityType(entityTypeStr);
        if (entityType == null) {
            player.sendMessage("Invalid entity type: " + entityTypeStr);
            return;
        }

        if (npc.isSpawned()) {
            npc.despawn();
        }

        npc = new NPC(id, entityType);
        npc.setName(NPCRegistry.get(id).getName());

        NPCRegistry.unregister(id);
        NPCRegistry.register(npc);
        npc.spawn(npc.getPosition());
        storage.saveNPC(npc);

        player.sendMessage("Set entity type of NPC '" + id + "' to " + entityTypeStr);
    }

    private void handleMove(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Usage: /npc move <id>");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        Location loc = new Location(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(),
                player.getLocation().getYaw(), player.getLocation().getPitch());
        npc.setPosition(loc);

        if (npc.isSpawned()) {
            npc.despawn();
            npc.spawn(loc);
        }

        storage.saveNPC(npc);
        player.sendMessage("Moved NPC '" + id + "' to your location");
    }

    private void handleOptions(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc options <id> <option> <value>");
            player.sendMessage("Options: nametag, gravity, collision, silent, invulnerable");
            return;
        }

        String id = args[1];
        String option = args[2].toLowerCase();
        String value = args.length >= 4 ? args[3] : null;
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        NPCOptions opts = npc.getOptions();
        boolean boolValue = value == null || Boolean.parseBoolean(value);

        switch (option) {
            case "nametag" -> opts.showNameTag(boolValue);
            case "gravity" -> opts.gravity(boolValue);
            case "collision", "collides" -> opts.collides(boolValue);
            case "silent" -> opts.silent(boolValue);
            case "invulnerable" -> opts.invulnerable(boolValue);
            case "lookatplayers" -> opts.lookAtPlayers(boolValue);
            case "lookatplayersperplayer" -> opts.lookAtPlayersPerPlayer(boolValue);
            case "lookatpath" -> opts.lookAtPath(boolValue);
            case "lookforward" -> opts.lookForward(boolValue);
            case "clampground" -> opts.clampToGround(boolValue);
            case "permanentlyvisible" -> opts.permanentlyVisible(boolValue);
            case "viewdistance" -> {
                if (value != null) {
                    opts.viewDistance(Double.parseDouble(value));
                }
            }
            case "speed" -> {
                if (value != null) {
                    opts.movementSpeed(Double.parseDouble(value));
                }
            }
            default -> {
                player.sendMessage("Unknown option: " + option);
                return;
            }
        }

        storage.saveNPC(npc);
        player.sendMessage("Set " + option + " to " + boolValue + " for NPC '" + id + "'");
    }

    private void handleWalk(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Usage: /npc walk <id> [speed]");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        double speed = args.length >= 3 ? Double.parseDouble(args[2]) : 4.0;

        Location target = new Location(
                player.getLocation().getX(),
                player.getLocation().getY(),
                player.getLocation().getZ(),
                player.getLocation().getYaw(),
                player.getLocation().getPitch()
        );

        npc.getPath().clearWaypoints();
        npc.getPath().addWaypoint(target);
        npc.getPath().setSpeed(speed);
        
        NPCMovement.startPathFollowing(npc);

        player.sendMessage("NPC '" + id + "' is now walking to your location");
    }

    private void handleStop(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("Usage: /npc stop <id>");
            return;
        }

        String id = args[1];
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        npc.stopMoving();
        player.sendMessage("Stopped NPC '" + id + "'");
    }

    private void handlePath(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage("Usage: /npc path <id> <add|remove|clear|list|start|loop|speed> [args]");
            return;
        }

        String id = args[1];
        String action = args[2].toLowerCase();
        NPC npc = NPCRegistry.get(id);

        if (npc == null) {
            player.sendMessage("NPC '" + id + "' not found");
            return;
        }

        NPCPath path = npc.getPath();

        switch (action) {
            case "add" -> {
                path.addWaypoint(new Location(
                        player.getLocation().getX(),
                        player.getLocation().getY(),
                        player.getLocation().getZ(),
                        player.getLocation().getYaw(),
                        player.getLocation().getPitch()
                ));
                player.sendMessage("Added waypoint to NPC '" + id + "' (total: " + path.getWaypointCount() + ")");
            }
            case "clear" -> {
                path.clearWaypoints();
                NPCMovement.stop(npc);
                player.sendMessage("Cleared path for NPC '" + id + "'");
            }
            case "list" -> {
                if (path.getWaypointCount() == 0) {
                    player.sendMessage("No waypoints for NPC '" + id + "'");
                } else {
                    player.sendMessage("Waypoints for NPC '" + id + "':");
                    for (int i = 0; i < path.getWaypoints().size(); i++) {
                        Location loc = path.getWaypoints().get(i);
                        player.sendMessage("  " + i + ": " + (int) loc.getX() + ", " + (int) loc.getY() + ", " + (int) loc.getZ());
                    }
                }
            }
            case "start" -> {
                if (path.getWaypointCount() == 0) {
                    player.sendMessage("No waypoints to follow");
                    return;
                }
                path.reset();
                NPCMovement.startPathFollowing(npc);
                player.sendMessage("NPC '" + id + "' started following path");
            }
            case "loop" -> {
                boolean loop = args.length >= 4 && Boolean.parseBoolean(args[3]);
                path.setLooping(loop);
                player.sendMessage("Looping " + (loop ? "enabled" : "disabled") + " for NPC '" + id + "'");
            }
            case "speed" -> {
                double speed = args.length >= 4 ? Double.parseDouble(args[3]) : 4.0;
                path.setSpeed(speed);
                player.sendMessage("Speed set to " + speed + " for NPC '" + id + "'");
            }
            default -> player.sendMessage("Unknown action: " + action);
        }

        storage.saveNPC(npc);
    }

    private void sendHelp(Player player) {
        player.sendMessage("=== NPC Commands ===");
        player.sendMessage("§7/npc create <id> <type> [name] §f- Create NPC");
        player.sendMessage("§7/npc remove <id> §f- Remove NPC");
        player.sendMessage("§7/npc list §f- List all NPCs");
        player.sendMessage("§7/npc teleport <id> §f- Teleport to NPC");
        player.sendMessage("§7/npc name <id> <name> §f- Set NPC name");
        player.sendMessage("§7/npc skin <id> <player> §f- Set NPC skin");
        player.sendMessage("§7/npc type <id> <type> §f- Change entity type");
        player.sendMessage("§7/npc move <id> §f- Instantly move NPC to you");
        player.sendMessage("§7/npc walk <id> [speed] §f- Walk NPC to you");
        player.sendMessage("§7/npc stop <id> §f- Stop NPC movement");
        player.sendMessage("§7/npc path <id> <add|start|list|clear|loop|speed> §f- Path waypoints");
        player.sendMessage("§7/npc options <id> <option> <value> §f- Toggle options");
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!(sender instanceof Player)) {
            return completions;
        }

        if (args.length == 1) {
            completions.addAll(List.of("create", "remove", "list", "teleport", "name", "skin", "type", "move", "walk", "stop", "path", "options"));
        } else if (args.length == 2) {
            String sub = args[0].toLowerCase();
            if (sub.equals("path")) {
                completions.addAll(List.of("add", "remove", "list", "clear", "start", "loop", "speed"));
            } else if (sub.equals("remove") || sub.equals("teleport") || sub.equals("name") || sub.equals("skin") || 
                sub.equals("type") || sub.equals("move") || sub.equals("walk") || sub.equals("stop") || 
                sub.equals("options")) {
                for (NPC npc : NPCRegistry.getAll()) {
                    completions.add(npc.getId());
                }
            } else if (sub.equals("create")) {
                for (String type : List.of("PLAYER", "ZOMBIE", "SKELETON", "PIG", "COW", "CHICKEN", "SHEEP", "HORSE", "ARMOR_STAND", "TEXT_DISPLAY")) {
                    completions.add(type);
                }
            }
        } else if (args.length == 3) {
            String sub = args[0].toLowerCase();
            switch (sub) {
                case "path" -> {
                    String action = args[1].toLowerCase();
                    if (action.equals("loop")) {
                        completions.addAll(List.of("true", "false"));
                    } else if (action.equals("speed")) {
                        completions.add("4.0");
                    }
                }
                case "options" ->
                        completions.addAll(List.of("nametag", "gravity", "collision", "silent", "invulnerable", "lookatplayers", "lookatplayersperplayer", "lookatpath", "lookforward", "clampground", "permanentlyvisible", "viewdistance", "speed"));
                case "type" -> {
                    for (String type : List.of("PLAYER", "ZOMBIE", "SKELETON", "PIG", "COW", "CHICKEN", "SHEEP", "HORSE", "ARMOR_STAND", "TEXT_DISPLAY")) {
                        completions.add(type);
                    }
                }
                case "create" -> completions.add("<name>");
            }
        } else if (args.length == 4) {
            String sub = args[0].toLowerCase();
            if (sub.equals("options")) {
                completions.addAll(List.of("true", "false"));
            }
        }

        String currentArg = args[args.length - 1].toLowerCase();
        if (!currentArg.isEmpty()) {
            completions.removeIf(s -> !s.toLowerCase().startsWith(currentArg));
        }

        return completions;
    }
}
