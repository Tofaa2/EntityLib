package me.tofaa.entitylib.npc.interactions;

import me.tofaa.entitylib.npc.NPC;
import me.tofaa.entitylib.npc.NPCOptions;
import me.tofaa.entitylib.npc.SpaceNPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Logger;

public class InteractionHandler {

    private static final Logger LOGGER = Bukkit.getLogger();

    public static void handleInteraction(NPC npc, Player player, InteractionType interactionType) {
        if (npc == null || player == null || interactionType == null) {
            return;
        }

        NPCOptions options = npc.getOptions();

        List<InteractionAction> anyActions = options.getInteractions(InteractionType.ANY);
        executeActions(anyActions, player, npc);

        List<InteractionAction> actions = options.getInteractions(interactionType);
        executeActions(actions, player, npc);
    }

    private static void executeActions(List<InteractionAction> actions, Player player, NPC npc) {
        if (actions == null || actions.isEmpty()) {
            return;
        }

        for (InteractionAction action : actions) {
            if (action == null) {
                continue;
            }

            String actionType = action.getActionType();
            String value = action.getValue();

            if (value == null || value.isEmpty()) {
                continue;
            }

            if (InteractionAction.RUN_COMMAND.equals(actionType)) {
                Bukkit.getScheduler().runTask(SpaceNPC.getInstance(), () -> {
                    executeCommand(player, value, npc);
                });
            } else if (InteractionAction.PLAYER_CHAT.equals(actionType)) {
                Bukkit.getScheduler().runTask(SpaceNPC.getInstance(), () -> {
                    player.chat(value.replace("%player%", player.getName()).replace("%npc%", npc.getId()));
                });
            } else if (InteractionAction.MESSAGE.equals(actionType)) {
                player.sendMessage(value.replace("%player%", player.getName()));
            }
        }
    }

    private static void executeCommand(Player player, String command, NPC npc) {
        String finalCommand = command
                .replace("%player%", player.getName())
                .replace("%npc%", npc.getId());

        if (finalCommand.startsWith("/")) {
            finalCommand = finalCommand.substring(1);
        }

        try {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), finalCommand);
        } catch (Exception e) {
            LOGGER.warning("[SpaceNPC] Failed to execute command '" + finalCommand + "' for player " + player.getName() + ": " + e.getMessage());
        }
    }
}
