package me.tofaa.entitylib.npc.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InteractionAction {

    public static final String RUN_COMMAND = "RUN_COMMAND";
    public static final String MESSAGE = "MESSAGE";

    private InteractionType type;
    private String actionType;
    private String value;

    public InteractionAction() {
    }

    public InteractionAction(InteractionType type, String actionType, String value) {
        this.type = type;
        this.actionType = actionType;
        this.value = value;
    }

    public InteractionType getType() {
        return type;
    }

    public void setType(InteractionType type) {
        this.type = type;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRunCommand() {
        return RUN_COMMAND.equals(actionType);
    }

    public boolean isMessage() {
        return MESSAGE.equals(actionType);
    }

    public String serialize() {
        if (type == null || actionType == null || value == null) {
            return null;
        }
        return type.name() + ":" + actionType + ":" + value;
    }

    public static InteractionAction deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] parts = data.split(":", 3);
        if (parts.length != 3) {
            return null;
        }
        InteractionType type = InteractionType.fromString(parts[0]);
        if (type == null) {
            return null;
        }
        return new InteractionAction(type, parts[1], parts[2]);
    }

    public static class Serializer {
        public static String serializeAll(Map<InteractionType, List<InteractionAction>> interactions) {
            if (interactions == null || interactions.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<InteractionType, List<InteractionAction>> entry : interactions.entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) {
                    continue;
                }
                if (sb.length() > 0) sb.append("|");
                sb.append(entry.getKey().name()).append("={");
                StringBuilder actionsSb = new StringBuilder();
                for (InteractionAction action : entry.getValue()) {
                    if (actionsSb.length() > 0) actionsSb.append(",");
                    if (action != null && action.actionType != null && action.value != null) {
                        actionsSb.append(escape(action.actionType)).append(":").append(escape(action.value));
                    }
                }
                sb.append(actionsSb.toString()).append("}");
            }
            return sb.toString();
        }

        private static String escape(String s) {
            if (s == null) return "";
            return s.replace("\\", "\\\\").replace(",", "\\,").replace(":", "\\:").replace("{", "\\{").replace("}", "\\}").replace("|", "\\|");
        }

        private static String unescape(String s) {
            if (s == null) return "";
            StringBuilder result = new StringBuilder();
            boolean escape = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (escape) {
                    result.append(c);
                    escape = false;
                } else if (c == '\\') {
                    escape = true;
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }

        public static Map<InteractionType, List<InteractionAction>> deserializeAll(String data) {
            Map<InteractionType, List<InteractionAction>> result = new HashMap<>();
            if (data == null || data.isEmpty()) {
                return result;
            }
            String[] typeEntries = data.split("\\|");
            for (String typeEntry : typeEntries) {
                int braceStart = typeEntry.indexOf("={");
                int braceEnd = typeEntry.lastIndexOf("}");
                if (braceStart == -1 || braceEnd == -1) continue;
                
                String typeName = typeEntry.substring(0, braceStart);
                String actionsStr = typeEntry.substring(braceStart + 2, braceEnd);
                
                InteractionType type = InteractionType.fromString(typeName);
                if (type == null) continue;
                
                List<InteractionAction> actions = new ArrayList<>();
                StringBuilder current = new StringBuilder();
                boolean inEscape = false;
                
                for (int i = 0; i < actionsStr.length(); i++) {
                    char c = actionsStr.charAt(i);
                    if (inEscape) {
                        current.append(c);
                        inEscape = false;
                    } else if (c == '\\') {
                        inEscape = true;
                    } else if (c == ',') {
                        String actionStr = current.toString();
                        current = new StringBuilder();
                        int colonIdx = actionStr.indexOf(':');
                        if (colonIdx != -1) {
                            String actionType = unescape(actionStr.substring(0, colonIdx));
                            String value = unescape(actionStr.substring(colonIdx + 1));
                            if (!actionType.isEmpty() && !value.isEmpty()) {
                                actions.add(new InteractionAction(type, actionType, value));
                            }
                        }
                    } else {
                        current.append(c);
                    }
                }
                
                if (current.length() > 0) {
                    String actionStr = current.toString();
                    int colonIdx = actionStr.indexOf(':');
                    if (colonIdx != -1) {
                        String actionType = unescape(actionStr.substring(0, colonIdx));
                        String value = unescape(actionStr.substring(colonIdx + 1));
                        if (!actionType.isEmpty() && !value.isEmpty()) {
                            actions.add(new InteractionAction(type, actionType, value));
                        }
                    }
                }
                
                if (!actions.isEmpty()) {
                    result.put(type, actions);
                }
            }
            return result;
        }
    }
}
