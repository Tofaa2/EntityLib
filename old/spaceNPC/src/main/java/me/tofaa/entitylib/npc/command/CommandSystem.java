package me.tofaa.entitylib.npc.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;

public class CommandSystem {
    private static final MiniMessage MM = MiniMessage.miniMessage();
    private final JavaPlugin plugin;

    public CommandSystem(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(BaseCommand command) {
        CommandMap commandMap = getCommandMap();
        if (commandMap != null) {
            commandMap.register(plugin.getName(), command);
        }
    }

    private CommandMap getCommandMap() {
        try {
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            return (CommandMap) field.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Component mm(String miniMessage) {
        return MM.deserialize(miniMessage);
    }

    // ===== ARGS WRAPPER =====
    public static class Args {
        private final String[] raw;
        private final CommandSender sender;

        public Args(String[] args, CommandSender sender) {
            this.raw = args;
            this.sender = sender;
        }

        // Basic getters
        public String get(int index) {
            return index < raw.length ? raw[index] : null;
        }

        public String get(int index, String defaultValue) {
            String val = get(index);
            return val != null ? val : defaultValue;
        }

        public boolean has(int index) {
            return index < raw.length;
        }

        public int length() {
            return raw.length;
        }

        public boolean isEmpty() {
            return raw.length == 0;
        }

        public String[] raw() {
            return raw;
        }

        // Join remaining args from index
        public String join(int startIndex) {
            if (startIndex >= raw.length) return "";
            return String.join(" ", Arrays.copyOfRange(raw, startIndex, raw.length));
        }

        // Integer parsing with validation
        public OptionalInt getInt(int index) {
            try {
                return OptionalInt.of(Integer.parseInt(raw[index]));
            } catch (Exception e) {
                return OptionalInt.empty();
            }
        }

        public int getInt(int index, int defaultValue) {
            return getInt(index).orElse(defaultValue);
        }

        public OptionalInt getInt(int index, int min, int max) {
            OptionalInt val = getInt(index);
            if (val.isPresent()) {
                int v = val.getAsInt();
                if (v < min || v > max) return OptionalInt.empty();
            }
            return val;
        }

        // Boolean parsing (true/yes/1/on vs false/no/0/off)
        public Optional<Boolean> getBool(int index) {
            String val = get(index);
            if (val == null) return Optional.empty();

            switch (val.toLowerCase()) {
                case "true":
                case "yes":
                case "1":
                case "on":
                case "enable":
                case "enabled":
                    return Optional.of(true);
                case "false":
                case "no":
                case "0":
                case "off":
                case "disable":
                case "disabled":
                    return Optional.of(false);
                default:
                    return Optional.empty();
            }
        }

        public boolean getBool(int index, boolean defaultValue) {
            return getBool(index).orElse(defaultValue);
        }

        // Double/Float
        public OptionalDouble getDouble(int index) {
            try {
                return OptionalDouble.of(Double.parseDouble(raw[index]));
            } catch (Exception e) {
                return OptionalDouble.empty();
            }
        }

        public double getDouble(int index, double defaultValue) {
            return getDouble(index).orElse(defaultValue);
        }

        // Player parsing (online check)
        public Optional<Player> getPlayer(int index) {
            String name = get(index);
            if (name == null) return Optional.empty();
            Player player = Bukkit.getPlayerExact(name);
            return Optional.ofNullable(player);
        }

        // Validate and return error message component, or null if valid
        public Validation validate() {
            return new Validation(this);
        }

        // Chainable validation class
        public static class Validation {
            private final Args args;
            private Component error;
            private boolean valid = true;

            public Validation(Args args) {
                this.args = args;
            }

            public Validation minArgs(int min) {
                if (!valid) return this;
                if (args.length() < min) {
                    error = mm("<red>Not enough arguments. Minimum: <yellow>" + min);
                    valid = false;
                }
                return this;
            }

            public Validation maxArgs(int max) {
                if (!valid) return this;
                if (args.length() > max) {
                    error = mm("<red>Too many arguments. Maximum: <yellow>" + max);
                    valid = false;
                }
                return this;
            }

            public Validation arg(int index, Predicate<String> check, String errorMsg) {
                if (!valid) return this;
                String val = args.get(index);
                if (val == null || !check.test(val)) {
                    error = mm("<red>" + errorMsg);
                    valid = false;
                }
                return this;
            }

            public Validation intArg(int index, int min, int max) {
                if (!valid) return this;
                OptionalInt val = args.getInt(index);
                if (!val.isPresent()) {
                    error = mm("<red>Argument <yellow>" + (index + 1) + " <red>must be a number");
                    valid = false;
                } else if (val.getAsInt() < min || val.getAsInt() > max) {
                    error = mm("<red>Number must be between <yellow>" + min + " <red>and <yellow>" + max);
                    valid = false;
                }
                return this;
            }

            public Validation player(int index) {
                if (!valid) return this;
                if (!args.getPlayer(index).isPresent()) {
                    error = mm("<red>Player <yellow>" + args.get(index) + " <red>not found or offline");
                    valid = false;
                }
                return this;
            }

            public boolean passes() {
                return valid;
            }

            public Component getError() {
                return error;
            }

            public void sendError(CommandSender sender) {
                if (error != null) sender.sendMessage(error);
            }
        }
    }

    // ===== COMMAND SYSTEM =====
    public static abstract class BaseCommand extends BukkitCommand {
        private final Map<String, SubCommand> subCommands = new HashMap<>();

        protected BaseCommand(String name) {
            super(name);
        }

        protected BaseCommand(String name, String description, String usage, List<String> aliases) {
            super(name, description, usage, aliases);
        }

        public void addSubCommand(SubCommand cmd) {
            subCommands.put(cmd.getName().toLowerCase(), cmd);
            for (String alias : cmd.getAliases()) {
                subCommands.put(alias.toLowerCase(), cmd);
            }
        }

        @Override
        public boolean execute(CommandSender sender, String commandLabel, String[] args) {
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sendHelp(sender);
                return true;
            }

            SubCommand sub = subCommands.get(args[0].toLowerCase());
            if (sub == null) {
                sender.sendMessage(mm("<red>Unknown command. Type /<gold>" + getName() + " <red>help"));
                return true;
            }

            if (!sub.hasPermission(sender)) {
                sender.sendMessage(mm("<red>You don't have permission."));
                return true;
            }

            Args wrappedArgs = new Args(Arrays.copyOfRange(args, 1, args.length), sender);

            // Auto-validation
            Args.Validation validation = wrappedArgs.validate()
                    .minArgs(sub.getMinArgs())
                    .maxArgs(sub.getMaxArgs());

            if (!validation.passes()) {
                validation.sendError(sender);
                sender.sendMessage(mm("<red>Usage: <yellow>/" + getName() + " " + sub.getUsage()));
                return true;
            }

            return sub.execute(sender, wrappedArgs);
        }

        @Override
        public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
            if (args.length == 1) {
                List<String> completions = new ArrayList<>();
                for (SubCommand sub : new HashSet<>(subCommands.values())) {
                    if (sub.hasPermission(sender)) completions.add(sub.getName());
                }
                return filter(completions, args[0]);
            }

            SubCommand sub = subCommands.get(args[0].toLowerCase());
            if (sub != null) {
                Args wrapped = new Args(Arrays.copyOfRange(args, 1, args.length), sender);
                return filter(sub.tabComplete(sender, wrapped), args[args.length - 1]);
            }
            return Collections.emptyList();
        }

        private List<String> filter(List<String> list, String prefix) {
            if (prefix.isEmpty()) return list;
            List<String> filtered = new ArrayList<>();
            for (String s : list) {
                if (s.toLowerCase().startsWith(prefix.toLowerCase())) filtered.add(s);
            }
            return filtered;
        }

        private void sendHelp(CommandSender sender) {
            sender.sendMessage(mm("<gold><bold>=== " + getName() + " Commands ==="));
            for (SubCommand sub : new HashSet<>(subCommands.values())) {
                if (sub.hasPermission(sender)) {
                    sender.sendMessage(mm("<yellow>/" + getName() + " " + sub.getUsage() + " <gray>- " + sub.getDescription()));
                }
            }
        }
    }

    public static abstract class SubCommand {
        private final String name;
        private final String permission;
        private final List<String> aliases;
        private int minArgs = 0;
        private int maxArgs = Integer.MAX_VALUE;

        public SubCommand(String name, String permission, String... aliases) {
            this.name = name;
            this.permission = permission;
            this.aliases = Arrays.asList(aliases);
        }

        public SubCommand setArgs(int min, int max) {
            this.minArgs = min;
            this.maxArgs = max;
            return this;
        }

        public SubCommand setExactArgs(int count) {
            this.minArgs = count;
            this.maxArgs = count;
            return this;
        }

        public abstract boolean execute(CommandSender sender, Args args);

        public List<String> tabComplete(CommandSender sender, Args args) {
            return Collections.emptyList();
        }

        public boolean hasPermission(CommandSender sender) {
            return permission == null || sender.hasPermission(permission);
        }

        public String getName() { return name; }
        public List<String> getAliases() { return aliases; }
        public int getMinArgs() { return minArgs; }
        public int getMaxArgs() { return maxArgs; }
        public abstract String getDescription();
        public abstract String getUsage();
    }

    public static List<String> onlinePlayers() {
        List<String> players = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) players.add(p.getName());
        return players;
    }
}