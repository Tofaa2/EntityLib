package me.tofaa.entitylib.npc;

import com.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import java.util.function.Consumer;
import me.tofaa.entitylib.APIConfig;
import me.tofaa.entitylib.EntityLib;
import me.tofaa.entitylib.extras.skin.SkinFetcher;
import me.tofaa.entitylib.npc.command.CommandSystem;
import me.tofaa.entitylib.npc.command.NPCCommand;
import me.tofaa.entitylib.npc.storage.NPCStorage;
import me.tofaa.entitylib.spigot.SpigotEntityLibPlatform;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class SpaceNPC extends JavaPlugin {

    private static SpaceNPC instance;
    private NPCStorage storage;
    private SkinFetcher skinFetcher;

    @Override
    public void onLoad() {
        instance = this;

        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().init();
    }

    @Override
    public void onEnable() {
        instance = this;

        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig config = new APIConfig(PacketEvents.getAPI())
            .tickTickables()
            .usePlatformLogger();

        EntityLib.init(platform, config);

        saveDefaultConfig();

        skinFetcher = SkinFetcher.builder().build();
        storage = new NPCStorage(this);

        NPCMovement.init(this);

        NPCCommand npcCommand = new NPCCommand(storage, skinFetcher);
        CommandSystem commandSystem = new CommandSystem(this);
        commandSystem.register(npcCommand);

        getServer()
            .getPluginManager()
            .registerEvents(new NPCPlayerListener(), this);

        NPCListenerManager.register(this);

        storage.loadAllNPCs();

        getLogger().info("SpaceNPC enabled!");
    }

    @Override
    public void onDisable() {
        NPCMovement.shutdown();
        storage.saveAll();
        NPCRegistry.clear();
        getLogger().info("SpaceNPC disabled!");
    }

    public static @NotNull SpaceNPC getInstance() {
        return instance;
    }

    public @NotNull NPCStorage getStorage() {
        return storage;
    }

    public @NotNull SkinFetcher getSkinFetcher() {
        return skinFetcher;
    }

    public void registerInteractionHandler(
        Consumer<NPCListenerManager.NPCInteractEvent> leftClick,
        Consumer<NPCListenerManager.NPCInteractEvent> rightClick
    ) {
        NPCListenerManager.registerInteraction(leftClick, rightClick);
    }
}
