package me.tofaa.entitylib.npc.command;

import static me.tofaa.entitylib.npc.command.CommandSystem.mm;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.player.TextureProperty;
import com.github.retrooper.packetevents.protocol.world.Location;
import com.google.common.collect.Lists;
import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.tofaa.entitylib.extras.skin.SkinFetcher;
import me.tofaa.entitylib.npc.NPC;
import me.tofaa.entitylib.npc.NPCMovement;
import me.tofaa.entitylib.npc.NPCOptions;
import me.tofaa.entitylib.npc.NPCRegistry;
import me.tofaa.entitylib.npc.interactions.InteractionAction;
import me.tofaa.entitylib.npc.interactions.InteractionType;
import me.tofaa.entitylib.npc.path.NPCPath;
import me.tofaa.entitylib.npc.skin.NPCSkin;
import me.tofaa.entitylib.npc.storage.NPCStorage;
import me.tofaa.entitylib.wrapper.WrapperLivingEntity;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NPCCommand extends CommandSystem.BaseCommand {

    private final NPCStorage storage;
    private final SkinFetcher skinFetcher;

    public NPCCommand(NPCStorage storage, SkinFetcher skinFetcher) {
        super(
            "spacenpc",
            "SpaceNPC main command",
            "/spacenpc [args]",
            Lists.newArrayList("npc", "npcs", "spacenpcs")
        );
        setPermission("spacenpcs.admin");
        this.storage = storage;
        this.skinFetcher = skinFetcher;
        registerSubCommands();
    }

    private void registerSubCommands() {
        addSubCommand(new Create());
        addSubCommand(new Remove());
        addSubCommand(new ListCommand());
        addSubCommand(new Teleport());
        addSubCommand(new Name());
        addSubCommand(new Skin());
        addSubCommand(new Type());
        addSubCommand(new Move());
        addSubCommand(new Walk());
        addSubCommand(new Stop());
        addSubCommand(new Path());
        addSubCommand(new Options());
        addSubCommand(new Interaction());
        addSubCommand(new CopySkin());
        addSubCommand(new Inventory());
        addSubCommand(new Reload());
    }

    private NPC getNPC(String id, CommandSender sender) {
        NPC npc = NPCRegistry.get(id);
        if (npc == null) {
            sender.sendMessage(
                mm("<red>NPC '<yellow>" + id + "<red>' not found")
            );
        }
        return npc;
    }

    private Location playerLocation(Player player) {
        return new Location(
            player.getLocation().getX(),
            player.getLocation().getY(),
            player.getLocation().getZ(),
            player.getLocation().getYaw(),
            player.getLocation().getPitch()
        );
    }

    private EntityType getEntityType(String name) {
        return EntityTypes.getByName(name.toLowerCase());
    }

    private List<String> getEntityTypeCompletions() {
        return Lists.newArrayList(
            "PLAYER",
            "ZOMBIE",
            "SKELETON",
            "PIG",
            "COW",
            "CHICKEN",
            "SHEEP",
            "HORSE",
            "ARMOR_STAND",
            "TEXT_DISPLAY"
        );
    }

    public class Create extends CommandSystem.SubCommand {

        Create() {
            super("create", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(2);

            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm(
                        "<red>Usage: <yellow>/spacenpc create <id> <type> [name]"
                    )
                );
                return true;
            }

            String id = args.get(0);
            String typeStr = args.get(1).toLowerCase();
            String name = args.has(2) ? args.get(2) : id;

            if (NPCRegistry.get(id) != null) {
                sender.sendMessage(
                    mm(
                        "<red>NPC with id '<yellow>" +
                            id +
                            "<red>' already exists"
                    )
                );
                return true;
            }

            EntityType entityType = NPCCommand.this.getEntityType(typeStr);
            if (entityType == null) {
                sender.sendMessage(
                    mm("<red>Invalid entity type: <yellow>" + typeStr)
                );
                return true;
            }

            NPC npc = new NPC(id, entityType);
            npc.setName(name);
            npc.setWorldName(player.getLocation().getWorld().getName());
            Location loc = NPCCommand.this.playerLocation(player);

            NPCRegistry.register(npc);
            npc.spawn(loc);
            storage.saveNPC(npc);

            sender.sendMessage(
                mm(
                    "<green>Created NPC '<yellow>" +
                        id +
                        "<green>' with entity type <yellow>" +
                        typeStr
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return new ArrayList<>(
                    NPCRegistry.getAll()
                        .stream()
                        .map(NPC::getId)
                        .filter(id -> NPCRegistry.get(id) == null)
                        .collect(Collectors.toList())
                );
            } else if (args.length() == 2) {
                return NPCCommand.this.getEntityTypeCompletions()
                    .stream()
                    .filter(t ->
                        t
                            .toLowerCase()
                            .startsWith(args.get(1, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 3) {
                return Lists.newArrayList("<name>");
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Create an NPC";
        }

        @Override
        public String getUsage() {
            return "create <id> <type> [name]";
        }
    }

    public class Remove extends CommandSystem.SubCommand {

        Remove() {
            super("remove", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(1);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc remove <id>")
                );
                return true;
            }

            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            npc.remove();
            storage.deleteNPC(id);
            sender.sendMessage(
                mm("<green>Removed NPC '<yellow>" + id + "<green>'")
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Remove an NPC";
        }

        @Override
        public String getUsage() {
            return "remove <id>";
        }
    }

    public class ListCommand extends CommandSystem.SubCommand {

        ListCommand() {
            super("list", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            List<NPC> npcs = new ArrayList<>(NPCRegistry.getAll());

            if (npcs.isEmpty()) {
                sender.sendMessage(mm("<yellow>No NPCs exist"));
                return true;
            }

            sender.sendMessage(
                mm("<yellow>NPCs (<white>" + npcs.size() + "<yellow>):")
            );
            for (NPC npc : npcs) {
                sender.sendMessage(
                    mm(
                        "<white>  - <yellow>" +
                            npc.getId() +
                            " <gray>(" +
                            npc.getEntityType() +
                            ") <white>at " +
                            (int) npc.getPosition().getX() +
                            ", " +
                            (int) npc.getPosition().getY() +
                            ", " +
                            (int) npc.getPosition().getZ()
                    )
                );
            }
            return true;
        }

        @Override
        public String getDescription() {
            return "List all NPCs";
        }

        @Override
        public String getUsage() {
            return "list";
        }
    }

    public class Teleport extends CommandSystem.SubCommand {

        Teleport() {
            super("teleport", "spacenpcs.admin", "tp");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(1);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc teleport <id>")
                );
                return true;
            }

            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            Location loc = npc.getPosition();
            player.teleport(
                new org.bukkit.Location(
                    player.getWorld(),
                    loc.getX(),
                    loc.getY(),
                    loc.getZ(),
                    loc.getYaw(),
                    loc.getPitch()
                )
            );

            sender.sendMessage(
                mm("<green>Teleported to NPC '<yellow>" + id + "<green>'")
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Teleport to an NPC";
        }

        @Override
        public String getUsage() {
            return "teleport <id>";
        }
    }

    public class Name extends CommandSystem.SubCommand {

        Name() {
            super("name", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(2);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc name <id> <name>")
                );
                return true;
            }

            String id = args.get(0);
            String name = args.get(1);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            npc.setName(name);
            storage.saveNPC(npc);
            sender.sendMessage(
                mm(
                    "<green>Set name of NPC '<yellow>" +
                        id +
                        "<green>' to '<yellow>" +
                        name +
                        "<green>'"
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Set NPC name";
        }

        @Override
        public String getUsage() {
            return "name <id> <name>";
        }
    }

    public class Skin extends CommandSystem.SubCommand {

        Skin() {
            super("skin", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(2);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc skin <id> <player>")
                );
                return true;
            }

            String id = args.get(0);
            String playerName = args.get(1);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            sender.sendMessage(
                mm(
                    "<yellow>Fetching skin for <white>" +
                        playerName +
                        "<yellow>..."
                )
            );

            List<TextureProperty> skins = skinFetcher.getSkin(playerName);
            if (skins.isEmpty()) {
                sender.sendMessage(
                    mm("<red>Failed to fetch skin for <yellow>" + playerName)
                );
                return true;
            }

            TextureProperty skin = skins.get(0);
            npc.setSkin(new NPCSkin(skin.getValue(), skin.getSignature()));

            if (npc.isSpawned()) {
                npc.despawn();
                npc.spawn(npc.getPosition());
            }

            storage.saveNPC(npc);
            sender.sendMessage(
                mm(
                    "<green>Set skin of NPC '<yellow>" +
                        id +
                        "<green>' to <white>" +
                        playerName
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                return CommandSystem.onlinePlayers()
                    .stream()
                    .filter(p ->
                        p
                            .toLowerCase()
                            .startsWith(args.get(1, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Set NPC skin";
        }

        @Override
        public String getUsage() {
            return "skin <id> <player>";
        }
    }

    public class Type extends CommandSystem.SubCommand {

        Type() {
            super("type", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(2);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc type <id> <type>")
                );
                return true;
            }

            String id = args.get(0);
            String typeStr = args.get(1).toLowerCase();
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            EntityType entityType = NPCCommand.this.getEntityType(typeStr);
            if (entityType == null) {
                sender.sendMessage(
                    mm("<red>Invalid entity type: <yellow>" + typeStr)
                );
                return true;
            }

            String oldName = npc.getName();
            if (npc.isSpawned()) {
                npc.despawn();
            }

            NPC newNpc = new NPC(id, entityType);
            newNpc.setName(oldName);

            NPCRegistry.unregister(id);
            NPCRegistry.register(newNpc);
            newNpc.spawn(npc.getPosition());
            storage.saveNPC(newNpc);

            sender.sendMessage(
                mm(
                    "<green>Set entity type of NPC '<yellow>" +
                        id +
                        "<green>' to <yellow>" +
                        typeStr
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                return NPCCommand.this.getEntityTypeCompletions()
                    .stream()
                    .filter(t ->
                        t
                            .toLowerCase()
                            .startsWith(args.get(1, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Change entity type";
        }

        @Override
        public String getUsage() {
            return "type <id> <type>";
        }
    }

    public class Move extends CommandSystem.SubCommand {

        Move() {
            super("move", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(1);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc move <id>")
                );
                return true;
            }

            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            Location loc = NPCCommand.this.playerLocation(player);
            npc.setPosition(loc);

            if (npc.isSpawned()) {
                npc.despawn();
                npc.spawn(loc);
            }

            storage.saveNPC(npc);
            sender.sendMessage(
                mm(
                    "<green>Moved NPC '<yellow>" +
                        id +
                        "<green>' to your location"
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Instantly move NPC to you";
        }

        @Override
        public String getUsage() {
            return "move <id>";
        }
    }

    public class Walk extends CommandSystem.SubCommand {

        Walk() {
            super("walk", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(1);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc walk <id> [speed]")
                );
                return true;
            }

            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            double speed = args.getDouble(1, 4.0);
            Location target = NPCCommand.this.playerLocation(player);

            npc.getPath().clearWaypoints();
            npc.getPath().addWaypoint(target);
            npc.getPath().setSpeed(speed);
            NPCMovement.startPathFollowing(npc);

            sender.sendMessage(
                mm(
                    "<green>NPC '<yellow>" +
                        id +
                        "<green>' is now walking to your location"
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                return Lists.newArrayList("4.0");
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Walk NPC to you";
        }

        @Override
        public String getUsage() {
            return "walk <id> [speed]";
        }
    }

    public class Stop extends CommandSystem.SubCommand {

        Stop() {
            super("stop", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            CommandSystem.Args.Validation validation = args
                .validate()
                .minArgs(1);
            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(
                    mm("<red>Usage: <yellow>/spacenpc stop <id>")
                );
                return true;
            }

            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            npc.stopMoving();
            sender.sendMessage(
                mm("<green>Stopped NPC '<yellow>" + id + "<green>'")
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Stop NPC movement";
        }

        @Override
        public String getUsage() {
            return "stop <id>";
        }
    }

    public class Path extends CommandSystem.SubCommand {

        Path() {
            super("path", "spacenpcs.admin");
            setArgs(2, Integer.MAX_VALUE);
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            if (args.length() < 2) {
                sender.sendMessage(
                    mm(
                        "<red>Usage: <yellow>/spacenpc path <id> <add|remove|clear|list|start|loop|speed> [args]"
                    )
                );
                return true;
            }

            String id = args.get(0);
            String action = args.get(1).toLowerCase();
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            NPCPath path = npc.getPath();

            switch (action) {
                case "add": {
                    path.addWaypoint(NPCCommand.this.playerLocation(player));
                    sender.sendMessage(
                        mm(
                            "<green>Added waypoint to NPC '<yellow>" +
                                id +
                                "<green>' <gray>(total: <white>" +
                                path.getWaypointCount() +
                                "<gray>)"
                        )
                    );
                    storage.saveNPC(npc);
                    break;
                }
                case "clear": {
                    path.clearWaypoints();
                    NPCMovement.stop(npc);
                    sender.sendMessage(
                        mm(
                            "<green>Cleared path for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    storage.saveNPC(npc);
                    break;
                }
                case "list": {
                    if (path.getWaypointCount() == 0) {
                        sender.sendMessage(
                            mm(
                                "<yellow>No waypoints for NPC '<yellow>" +
                                    id +
                                    "<yellow>'"
                            )
                        );
                    } else {
                        sender.sendMessage(
                            mm(
                                "<yellow>Waypoints for NPC '<yellow>" +
                                    id +
                                    "<yellow>':"
                            )
                        );
                        for (int i = 0; i < path.getWaypoints().size(); i++) {
                            Location loc = path.getWaypoints().get(i);
                            sender.sendMessage(
                                mm(
                                    "<white>  " +
                                        i +
                                        ": <gray>" +
                                        (int) loc.getX() +
                                        ", " +
                                        (int) loc.getY() +
                                        ", " +
                                        (int) loc.getZ()
                                )
                            );
                        }
                    }
                    break;
                }
                case "start": {
                    if (path.getWaypointCount() == 0) {
                        sender.sendMessage(mm("<red>No waypoints to follow"));
                        return true;
                    }
                    path.reset();
                    NPCMovement.startPathFollowing(npc);
                    sender.sendMessage(
                        mm(
                            "<green>NPC '<yellow>" +
                                id +
                                "<green>' started following path"
                        )
                    );
                    storage.saveNPC(npc);
                    break;
                }
                case "loop": {
                    boolean loop = args.getBool(2, false);
                    path.setLooping(loop);
                    sender.sendMessage(
                        mm(
                            "<green>Looping " +
                                (loop ? "enabled" : "disabled") +
                                " for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    storage.saveNPC(npc);
                    break;
                }
                case "speed": {
                    double speed = args.getDouble(2, 4.0);
                    path.setSpeed(speed);
                    sender.sendMessage(
                        mm(
                            "<green>Speed set to <yellow>" +
                                speed +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    storage.saveNPC(npc);
                    break;
                }
                default: {
                    sender.sendMessage(
                        mm("<red>Unknown action: <yellow>" + action)
                    );
                    break;
                }
            }
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                return Lists.newArrayList(
                    "add",
                    "clear",
                    "list",
                    "start",
                    "loop",
                    "speed"
                )
                    .stream()
                    .filter(a -> a.startsWith(args.get(1, "").toLowerCase()))
                    .collect(Collectors.toList());
            } else if (args.length() == 3) {
                String action = args.get(1).toLowerCase();
                if (action.equals("loop")) {
                    return Lists.newArrayList("true", "false")
                        .stream()
                        .filter(v ->
                            v.startsWith(args.get(2, "").toLowerCase())
                        )
                        .collect(Collectors.toList());
                } else if (action.equals("speed")) {
                    return Lists.newArrayList("4.0");
                }
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Path waypoints";
        }

        @Override
        public String getUsage() {
            return "path <id> <add|clear|list|start|loop|speed> [args]";
        }
    }

    public class Options extends CommandSystem.SubCommand {

        Options() {
            super("options", "spacenpcs.admin");
            setArgs(2, 3);
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (args.length() < 2) {
                sender.sendMessage(
                    mm(
                        "<red>Usage: <yellow>/spacenpc options <id> <option> [value]"
                    )
                );
                sender.sendMessage(
                    mm(
                        "<gray>Options: <white>nametag, gravity, collision, silent, invulnerable, lookatplayers, lookatplayersperplayer, lookatpath, lookforward, clampground, permanentlyvisible, viewdistance, speed, sitting"
                    )
                );
                return true;
            }

            String id = args.get(0);
            String option = args.get(1).toLowerCase();
            String valueStr = args.get(2);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            NPCOptions opts = npc.getOptions();
            boolean boolValue = parseBool(valueStr, true);

            switch (option) {
                case "nametag": {
                    opts.showNameTag(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>nametag <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "gravity": {
                    opts.gravity(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>gravity <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "collision":
                case "collides": {
                    opts.collides(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>collision <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "silent": {
                    opts.silent(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>silent <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "invulnerable": {
                    opts.invulnerable(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>invulnerable <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "lookatplayers": {
                    opts.lookAtPlayers(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>lookAtPlayers <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "lookatplayersperplayer": {
                    opts.lookAtPlayersPerPlayer(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>lookAtPlayersPerPlayer <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "lookatpath": {
                    opts.lookAtPath(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>lookAtPath <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "lookforward": {
                    opts.lookForward(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>lookForward <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "clampground": {
                    opts.clampToGround(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>clampToGround <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "permanentlyvisible": {
                    opts.permanentlyVisible(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>permanentlyVisible <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "viewdistance": {
                    double value = args.getDouble(2, 100.0);
                    opts.viewDistance(value);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>viewDistance <green>to <white>" +
                                value +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "speed": {
                    double value = args.getDouble(2, 4.0);
                    opts.movementSpeed(value);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>movementSpeed <green>to <white>" +
                                value +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    break;
                }
                case "sitting": {
                    opts.sitting(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>sitting <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    if (npc.isSpawned()) {
                        npc.despawn();
                        npc.spawn(npc.getPosition());
                    }
                    break;
                }
                case "swimming": {
                    opts.swimming(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>swimming <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    if (npc.isSpawned() && npc.getEntity().isPresent()) {
                        npc.getEntity().get().getEntityMeta().setSwimming(boolValue);
                    }
                    break;
                }
                case "crouching": {
                    opts.crouching(boolValue);
                    sender.sendMessage(
                        mm(
                            "<green>Set <yellow>crouching <green>to <white>" +
                                boolValue +
                                " <green>for NPC '<yellow>" +
                                id +
                                "<green>'"
                        )
                    );
                    if (npc.isSpawned() && npc.getEntity().isPresent()) {
                        npc.getEntity().get().getEntityMeta().setSneaking(boolValue);
                    }
                    break;
                }
                default: {
                    sender.sendMessage(
                        mm("<red>Unknown option: <yellow>" + option)
                    );
                    sender.sendMessage(
                        mm(
                        "<gray>Options: <white>nametag, gravity, collision, silent, invulnerable, lookatplayers, lookatplayersperplayer, lookatpath, lookforward, clampground, permanentlyvisible, viewdistance, speed, sitting, swimming, crouching"
                        )
                    );
                    return true;
                }
            }

            storage.saveNPC(npc);
            return true;
        }

        private boolean parseBool(String valueStr, boolean defaultValue) {
            if (valueStr == null) return defaultValue;
            switch (valueStr.toLowerCase()) {
                case "true":
                case "yes":
                case "1":
                case "on":
                case "enable":
                case "enabled":
                    return true;
                case "false":
                case "no":
                case "0":
                case "off":
                case "disable":
                case "disabled":
                    return false;
                default:
                    return defaultValue;
            }
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            List<String> optionNames = Lists.newArrayList(
                "nametag",
                "gravity",
                "collision",
                "silent",
                "invulnerable",
                "lookatplayers",
                "lookatplayersperplayer",
                "lookatpath",
                "lookforward",
                "clampground",
                "permanentlyvisible",
                "viewdistance",
                "speed",
                "sitting"
            );

            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                return optionNames
                    .stream()
                    .filter(o -> o.startsWith(args.get(1, "").toLowerCase()))
                    .collect(Collectors.toList());
            } else if (args.length() == 3) {
                String option = args.get(1).toLowerCase();
                if (option.equals("viewdistance") || option.equals("speed")) {
                    return Lists.newArrayList("4.0");
                } else {
                    return Lists.newArrayList("true", "false")
                        .stream()
                        .filter(v ->
                            v.startsWith(args.get(2, "").toLowerCase())
                        )
                        .collect(Collectors.toList());
                }
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Toggle options";
        }

        @Override
        public String getUsage() {
            return "options <id> <option> [value]";
        }
    }

    public class Interaction extends CommandSystem.SubCommand {

        Interaction() {
            super("interaction", "spacenpcs.admin", "interact");
            setArgs(3, Integer.MAX_VALUE);
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            String id = args.get(0);
            String actionStr = args.get(1).toLowerCase();

            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            NPCOptions opts = npc.getOptions();

            if (actionStr.equals("list")) {
                sender.sendMessage(
                    mm(
                        "<gold><bold>=== Interactions for NPC '<yellow>" +
                            id +
                            "<gold>' ==="
                    )
                );
                boolean hasAny = false;
                for (InteractionType type : InteractionType.values()) {
                    List<InteractionAction> actions = opts.getInteractions(
                        type
                    );
                    if (actions != null && !actions.isEmpty()) {
                        hasAny = true;
                        sender.sendMessage(
                            mm("<yellow>" + type.name().toLowerCase() + ":")
                        );
                        for (int i = 0; i < actions.size(); i++) {
                            InteractionAction action = actions.get(i);
                            if (action != null) {
                                sender.sendMessage(
                                    mm(
                                        "  <white>[" +
                                            i +
                                            "] <gray>" +
                                            action.getActionType() +
                                            " <white>" +
                                            action.getValue()
                                    )
                                );
                            }
                        }
                    }
                }
                if (!hasAny) {
                    sender.sendMessage(mm("<gray>No interactions set"));
                }
                sender.sendMessage(
                    mm(
                        "<gray>Use <white>/spacenpc interact <id> <type> add <action> <value> <gray>to add more"
                    )
                );
                return true;
            }

            if (args.length() < 3) {
                sender.sendMessage(
                    mm(
                        "<red>Usage: <yellow>/spacenpc interact <id> <type> <add|remove|clear|list> [args]"
                    )
                );
                sender.sendMessage(
                    mm(
                        "<gray>Types: <white>right_click, left_click, shift_right_click, shift_left_click"
                    )
                );
                sender.sendMessage(
                    mm(
                        "<gray>Example: <white>/spacenpc interact mynpc right_click add run_command /say Hello %player%!"
                    )
                );
                return true;
            }

            String interactionTypeStr = args.get(2).toLowerCase();
            InteractionType interactionType = InteractionType.fromString(
                interactionTypeStr
            );
            if (interactionType == null) {
                sender.sendMessage(
                    mm(
                        "<red>Invalid interaction type: <yellow>" +
                            interactionTypeStr
                    )
                );
                sender.sendMessage(
                    mm(
                        "<gray>Valid types: <white>right_click, left_click, shift_right_click, shift_left_click"
                    )
                );
                return true;
            }

            if (actionStr.equals("add")) {
                if (args.length() < 5) {
                    sender.sendMessage(
                        mm(
                            "<red>Usage: <yellow>/spacenpc interact <id> <type> add <action> <value>"
                        )
                    );
                    sender.sendMessage(
                        mm("<gray>Actions: <white>run_command, message")
                    );
                    sender.sendMessage(
                        mm(
                            "<gray>Example: <white>/spacenpc interact mynpc right_click add run_command /say Hello"
                        )
                    );
                    return true;
                }

                String actionTypeStr = args.get(3).toLowerCase();
                String value = args.join(4);
                String valueWithoutSlash = value.startsWith("/")
                    ? value.substring(1)
                    : value;

                if (
                    actionTypeStr.equals("run_command") ||
                    actionTypeStr.equals("cmd") ||
                    actionTypeStr.equals("command")
                ) {
                    InteractionAction action = new InteractionAction(
                        interactionType,
                        InteractionAction.RUN_COMMAND,
                        valueWithoutSlash
                    );
                    opts.addInteraction(interactionType, action);
                    storage.saveNPC(npc);
                    List<InteractionAction> actions = opts.getInteractions(
                        interactionType
                    );
                    sender.sendMessage(
                        mm(
                            "<green>Added command to <yellow>" +
                                interactionType.name().toLowerCase() +
                                "<green>: <white>/" +
                                valueWithoutSlash
                        )
                    );
                    sender.sendMessage(
                        mm(
                            "<gray>Total actions for " +
                                interactionType.name().toLowerCase() +
                                ": <white>" +
                                actions.size()
                        )
                    );
                } else if (
                    actionTypeStr.equals("message") ||
                    actionTypeStr.equals("msg") ||
                    actionTypeStr.equals("say")
                ) {
                    InteractionAction action = new InteractionAction(
                        interactionType,
                        InteractionAction.MESSAGE,
                        value
                    );
                    opts.addInteraction(interactionType, action);
                    storage.saveNPC(npc);
                    List<InteractionAction> actions = opts.getInteractions(
                        interactionType
                    );
                    sender.sendMessage(
                        mm(
                            "<green>Added message to <yellow>" +
                                interactionType.name().toLowerCase() +
                                "<green>: <white>" +
                                value
                        )
                    );
                    sender.sendMessage(
                        mm(
                            "<gray>Total actions for " +
                                interactionType.name().toLowerCase() +
                                ": <white>" +
                                actions.size()
                        )
                    );
                } else {
                    sender.sendMessage(
                        mm("<red>Unknown action type: <yellow>" + actionTypeStr)
                    );
                    sender.sendMessage(
                        mm("<gray>Actions: <white>run_command, message")
                    );
                }
                return true;
            }

            if (actionStr.equals("remove") || actionStr.equals("delete")) {
                if (args.length() < 4) {
                    sender.sendMessage(
                        mm(
                            "<red>Usage: <yellow>/spacenpc interact <id> <type> remove <index>"
                        )
                    );
                    List<InteractionAction> actions = opts.getInteractions(
                        interactionType
                    );
                    if (!actions.isEmpty()) {
                        sender.sendMessage(
                            mm(
                                "<gray>Available indices for <white>" +
                                    interactionType.name().toLowerCase() +
                                    "<gray>:"
                            )
                        );
                        for (int i = 0; i < actions.size(); i++) {
                            InteractionAction action = actions.get(i);
                            sender.sendMessage(
                                mm(
                                    "  <white>[" +
                                        i +
                                        "] <gray>" +
                                        action.getActionType() +
                                        " <white>" +
                                        action.getValue()
                                )
                            );
                        }
                    }
                    return true;
                }

                String indexStr = args.get(3);
                int index;
                try {
                    index = Integer.parseInt(indexStr);
                } catch (NumberFormatException e) {
                    sender.sendMessage(
                        mm("<red>Invalid index: <yellow>" + indexStr)
                    );
                    return true;
                }

                List<InteractionAction> actions = opts.getInteractions(
                    interactionType
                );
                if (index < 0 || index >= actions.size()) {
                    sender.sendMessage(
                        mm(
                            "<red>Index out of bounds. Valid range: <yellow>0-" +
                                (actions.size() - 1)
                        )
                    );
                    return true;
                }

                InteractionAction removed = actions.get(index);
                opts.removeInteraction(interactionType, index);
                storage.saveNPC(npc);
                sender.sendMessage(
                    mm(
                        "<green>Removed action <white>[" +
                            index +
                            "] <gray>" +
                            removed.getActionType() +
                            " <white>" +
                            removed.getValue()
                    )
                );
                sender.sendMessage(
                    mm(
                        "<green> from <yellow>" +
                            interactionType.name().toLowerCase()
                    )
                );
                return true;
            }

            if (actionStr.equals("clear") || actionStr.equals("reset")) {
                opts.clearInteractions(interactionType);
                storage.saveNPC(npc);
                sender.sendMessage(
                    mm(
                        "<green>Cleared all actions for <yellow>" +
                            interactionType.name().toLowerCase()
                    )
                );
                return true;
            }

            sender.sendMessage(mm("<red>Unknown action: <yellow>" + actionStr));
            sender.sendMessage(
                mm("<gray>Actions: <white>add, remove, clear, list")
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                List<String> actions = Lists.newArrayList(
                    "add",
                    "remove",
                    "clear",
                    "list"
                );
                return actions
                    .stream()
                    .filter(a -> a.startsWith(args.get(1, "").toLowerCase()))
                    .collect(Collectors.toList());
            } else if (args.length() == 3) {
                List<String> types = Lists.newArrayList(
                    "right_click",
                    "left_click",
                    "shift_right_click",
                    "shift_left_click",
                    "any"
                );
                return types
                    .stream()
                    .filter(t -> t.startsWith(args.get(2, "").toLowerCase()))
                    .collect(Collectors.toList());
            } else if (args.length() == 4) {
                String action = args.get(1);
                if (action.equals("add")) {
                    List<String> actionTypes = Lists.newArrayList(
                        "run_command",
                        "message"
                    );
                    return actionTypes
                        .stream()
                        .filter(a ->
                            a.startsWith(args.get(3, "").toLowerCase())
                        )
                        .collect(Collectors.toList());
                } else if (action.equals("remove")) {
                    String id = args.get(0);
                    String typeStr = args.get(2);
                    NPC npc = NPCRegistry.get(id);
                    if (npc != null) {
                        InteractionType type = InteractionType.fromString(
                            typeStr
                        );
                        if (type != null) {
                            List<InteractionAction> actions = npc
                                .getOptions()
                                .getInteractions(type);
                            List<String> indices = new ArrayList<>();
                            for (int i = 0; i < actions.size(); i++) {
                                indices.add(String.valueOf(i));
                            }
                            return indices
                                .stream()
                                .filter(idx -> idx.startsWith(args.get(3, "")))
                                .collect(Collectors.toList());
                        }
                    }
                }
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Manage NPC interactions";
        }

        @Override
        public String getUsage() {
            return "interact <id> <add|remove|clear|list> <type> [args]";
        }
    }

    // ===== RELOAD =====
    public class Reload extends CommandSystem.SubCommand {

        Reload() {
            super("reload", "spacenpcs.admin");
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            sender.sendMessage(mm("<yellow>Reloading SpaceNPC..."));

            for (NPC npc : NPCRegistry.getAll()) {
                npc.despawn();
            }
            NPCRegistry.clear();

            storage.saveAll();

            storage.loadAllNPCs();

            sender.sendMessage(mm("<green>SpaceNPC reloaded successfully!"));
            sender.sendMessage(
                mm("<gray>NPCs loaded: <white>" + NPCRegistry.count())
            );
            return true;
        }

        @Override
        public String getDescription() {
            return "Reload NPC configurations";
        }

        @Override
        public String getUsage() {
            return "reload";
        }
    }

    // ===== COPYSKIN =====
    public class CopySkin extends CommandSystem.SubCommand {

        CopySkin() {
            super("copyskin", "spacenpcs.admin", "copySkin");
            setArgs(1, 1);
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;
            String id = args.get(0);
            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            sender.sendMessage(
                mm(
                    "<yellow>Copying your skin to NPC '<yellow>" +
                        id +
                        "<yellow>'..."
                )
            );

            List<TextureProperty> skins = skinFetcher.getSkin(player.getName());
            if (skins.isEmpty()) {
                sender.sendMessage(mm("<red>Failed to fetch your skin"));
                return true;
            }

            TextureProperty skin = skins.get(0);
            npc.setSkin(new NPCSkin(skin.getValue(), skin.getSignature()));


            if (npc.isSpawned()) {
                npc.despawn();
                npc.spawn(npc.getPosition());
            }

            storage.saveNPC(npc);
            sender.sendMessage(
                mm(
                    "<green>Successfully copied your skin to NPC '<yellow>" +
                        id +
                        "<green>'"
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Copy your skin to an NPC";
        }

        @Override
        public String getUsage() {
            return "copyskin <id>";
        }
    }

    // ===== INVENTORY =====
    public class Inventory extends CommandSystem.SubCommand {

        Inventory() {
            super("inventory", "spacenpcs.admin", "inv");
            setArgs(2, 2);
        }

        @Override
        public boolean execute(CommandSender sender, CommandSystem.Args args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(
                    mm("<red>Only players can use this command")
                );
                return true;
            }
            Player player = (Player) sender;

            String id = args.get(0);
            String slotStr = args.get(1).toLowerCase();

            NPC npc = NPCCommand.this.getNPC(id, sender);
            if (npc == null) return true;

            Optional<?> entityOpt = npc.getEntity();
            if (
                !entityOpt.isPresent() ||
                !(entityOpt.get() instanceof WrapperLivingEntity)
            ) {
                sender.sendMessage(
                    mm(
                        "<red>NPC entity is not a living entity, cannot set equipment"
                    )
                );
                return true;
            }
            WrapperLivingEntity entity = (WrapperLivingEntity) entityOpt.get();

            String slotLower = slotStr.toLowerCase();
            org.bukkit.inventory.ItemStack bukkitItem = null;
            if (false) {
                switch (slotLower) {
                    case "helmet":
                    case "head":
                    case "hat":
                        bukkitItem = player.getInventory().getHelmet();
                        break;
                    case "chestplate":
                    case "chest":
                    case "body":
                        bukkitItem = player.getInventory().getChestplate();
                        break;
                    case "leggings":
                    case "legs":
                        bukkitItem = player.getInventory().getLeggings();
                        break;
                    case "boots":
                    case "feet":
                        bukkitItem = player.getInventory().getBoots();
                        break;
                    case "main":
                    case "mainhand":
                    case "hand":
                        bukkitItem = player.getInventory().getItemInMainHand();
                        break;
                    case "off":
                    case "offhand":
                    case "off_hand":
                        bukkitItem = player.getInventory().getItemInOffHand();
                        break;
                    default:
                        sender.sendMessage(
                                mm("<red>Invalid slot: <yellow>" + slotStr)
                        );
                        sender.sendMessage(
                                mm(
                                        "<gray>Valid slots: <white>helmet, chestplate, leggings, boots, main, off"
                                )
                        );
                        return true;
                }
            }
            else {
                bukkitItem = player.getInventory().getItemInMainHand();
            }

            if (bukkitItem == null || bukkitItem.getType().isAir()) {
                sender.sendMessage(
                    mm("<red>You don't have an item in that slot")
                );
                return true;
            }

            com.github.retrooper.packetevents.protocol.item.ItemStack itemStack =
                SpigotConversionUtil.fromBukkitItemStack(bukkitItem);

            switch (slotLower) {
                case "helmet":
                case "head":
                case "hat":
                    entity.getEquipment().setHelmet(itemStack);
                    break;
                case "chestplate":
                case "chest":
                case "body":
                    entity.getEquipment().setChestplate(itemStack);
                    break;
                case "leggings":
                case "legs":
                    entity.getEquipment().setLeggings(itemStack);
                    break;
                case "boots":
                case "feet":
                    entity.getEquipment().setBoots(itemStack);
                    break;
                case "main":
                case "mainhand":
                case "hand":
                    entity.getEquipment().setMainHand(itemStack);
                    break;
                case "off":
                case "offhand":
                case "off_hand":
                    entity.getEquipment().setOffhand(itemStack);
                    break;
            }

            storage.saveNPC(npc);
            sender.sendMessage(
                mm(
                    "<green>Set <yellow>" +
                        slotStr +
                        " <green>for NPC '<yellow>" +
                        id +
                        "<green>' to: <white>" +
                        bukkitItem.getType().name()
                )
            );
            return true;
        }

        @Override
        public List<String> tabComplete(
            CommandSender sender,
            CommandSystem.Args args
        ) {
            if (args.length() == 1) {
                return NPCRegistry.getAll()
                    .stream()
                    .map(NPC::getId)
                    .filter(id ->
                        id
                            .toLowerCase()
                            .startsWith(args.get(0, "").toLowerCase())
                    )
                    .collect(Collectors.toList());
            } else if (args.length() == 2) {
                List<String> slots = Lists.newArrayList(
                    "helmet",
                    "chestplate",
                    "leggings",
                    "boots",
                    "main",
                    "off"
                );
                return slots
                    .stream()
                    .filter(s -> s.startsWith(args.get(1, "").toLowerCase()))
                    .collect(Collectors.toList());
            }
            return Collections.emptyList();
        }

        @Override
        public String getDescription() {
            return "Set NPC equipment from your inventory";
        }

        @Override
        public String getUsage() {
            return "inventory <id> <slot>";
        }
    }
}
