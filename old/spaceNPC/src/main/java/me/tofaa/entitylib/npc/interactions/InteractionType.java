package me.tofaa.entitylib.npc.interactions;

public enum InteractionType {
    RIGHT_CLICK("right_click", "rightclick"),
    LEFT_CLICK("left_click", "leftclick"),
    SHIFT_RIGHT_CLICK("shift_right_click", "shiftrightclick", "shift_right", "shiftright"),
    SHIFT_LEFT_CLICK("shift_left_click", "shiftleftclick", "shift_left", "shiftleft"),
    ANY("any", "all");

    private final String[] aliases;

    InteractionType(String... aliases) {
        this.aliases = aliases;
    }

    public String[] getAliases() {
        return aliases;
    }

    public static InteractionType fromString(String name) {
        String lower = name.toLowerCase();
        for (InteractionType type : values()) {
            if (type.name().toLowerCase().equals(lower)) {
                return type;
            }
            for (String alias : type.aliases) {
                if (alias.equals(lower)) {
                    return type;
                }
            }
        }
        return null;
    }

    public static String[] getAllAliases() {
        StringBuilder sb = new StringBuilder();
        for (InteractionType type : values()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(type.name().toLowerCase());
            for (String alias : type.aliases) {
                sb.append(", ").append(alias);
            }
        }
        return new String[]{sb.toString()};
    }
}
