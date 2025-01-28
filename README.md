# EntityLib  
EntityLib is a PacketEvents addon that provides an abstraction over raw entity data and packets to make it easier to work with entities as a whole.
Currently, EntityLib is only stable for 1.18+, but it will support all versions that PacketEvents supports in the future. <br>
For general support and reports of bugs, join the [Discord](https://discord.gg/jawR25hrSK) server.

Currently supported platforms are `spigot` and `velocity`
You can easily use EntityLib platformless by using the `api` or `common` module

If you like EntityLib and or want to sponsor me, visit my [ko-fi page](https://ko-fi.com/tofaa) :D 

EntityLib builds are available on [Jitpack](https://jitpack.io/#Tofaa2/EntityLib) and my own [Maven Repository](https://maven.evokegames.gg/#/snapshots/me/tofaa/entitylib)
The examples below use my repository, open the jitpack link for its group information.

Gradle (Groovy DSL):
```groovy
repositories {
    maven { url 'https://maven.evokegames.gg/snapshots' }
}

dependencies {
    implementation 'me.tofaa.entitylib:<platform>:<latest-release-version'
}
```

Gradle (Kotlin DSL):
```kotlin
repositories {
    maven(url = "https://maven.evokegames.gg/snapshots")
}

dependencies {
    implementation("me.tofaa.entitylib:<platform>:<latest-release-version>")
}
```

Maven:
```xml 
<dependency>
    <groupId>me.tofaa.entitylib</groupId>
    <artifactId>(platform)</artifactId>
    <version>(latest-release-version)</version>
</dependency>
```

##  NOTE:
EntityLib does not provide packet-events as a dependency, you must have it in your classpath already. EntityLib will also stay at the latest packet-events version at all times

## Features
- Full EntityMeta support
- Creation of WrapperEntities
- Keeping track of entities.



## Usage

For more realistic examples, please take a look at the `test-plugin` module. It has an example `Bukkit` plugin that uses EntityLib.
Examples below show usage of the spigot module of entity lib, but the usage is the same for all platforms.
### Using the EntityMeta api

```java
class Example {

    public static void main(String[] args) {
        PacketEventsAPI api = ;// create PacketEventsAPI instance
        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig settings = new APIConfig(PacketEvents.getAPI())
                .debugMode()
                .tickTickables()
                .trackPlatformEntities()
                .usePlatformLogger();

        EntityLib.init(platform, settings);

        // Making a random entity using packet events raw, i strongly recommend using the EntityLib#createEntity method instead
        int entityID = 1;
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(constructor args);
        EntityMeta meta = EntityMeta.createMeta(entityId, EntityType);
        // You can cast the meta to the correct type depending on the entity type
        PigMeta pigMeta = (PigMeta) meta;

        // Once you're done modifying the meta accordingly, you can convert it to a packet, and send it to whoever you want for them  to see the changes.
        WrapperPlayServerEntityMetadata metaPacket = meta.createPacket();
        User.sendPacket(metaPacket);
    }

}
```

### Creating a WrapperEntity

```java
import com.github.retrooper.packetevents.protocol.world.Location;

class Example {

    public static void main(String[] args) {
        PacketEventsAPI api = ;// create PacketEventsAPI instance
        SpigotEntityLibPlatform platform = new SpigotEntityLibPlatform(this);
        APIConfig settings = new APIConfig(PacketEvents.getAPI())
                .debugMode()
                .tickTickables()
                .trackPlatformEntities()
                .usePlatformLogger();

        EntityLib.init(platform, settings);

        WrapperEntity entity = new WrapperEntity(EntityType); // optional uuid and entity id and meta 
        // You can keep track of the entity yourself or store its entityId or uuid and fetch it using EntityLib.getApi().getEntity(UUID or entityId)

        // Entities also have access to the EntityMeta api, the EntityMeta api can be used seperately from wrapper entities but also can be used together
        EntityMeta meta = entity.getEntityMeta();
        // Depending on the entity type, you can safely cast the meta to the correct type
        PigMeta meta1 = (PigMeta) meta; // If the entity type is EntityTypes.PIG

        // adding a viewer to the entity can be done before or after spawn, doesnt matter
        entity.addViewer(User); // UUID also applicable
        entity.removeViewer(User); // UUID also applicable

        entity.spawn(Location); // Spawns the entity at the given location
        entity.remove(); // Removes the entity from the world
        entity.rotateHead(float yaw, float pitch); // Rotates the head of the entity
        entity.teleport(Location); // Teleports the entity to the given location.
        
        // If the entityId provider for WrapperEntities is not working for you or needs changing, you can get it from EntityLib#getEntityIdProvider()
        // You can also set it to a custom provider if needed by calling EntityLib#setEntityIdProvider(EntityIdProvider)
        int randomEntityId = EntityLib.getPlatform().getEntityIdProvider().provide();
    }

}

```

### TODO:
Once this list is complete, i will release a stable version of the library.
- [ ] Implement checks for each EntityMeta to make sure the version specific data is correct.
- [ ] Verify all the EntityMeta packets are working correctly.
- [x] WrapperEntities must seamlessly send packet updates to viewers, currently they are not.
- [x] Add support for more actions using WrapperEntities.
- [x] More javadocs.
- [x] Make ObjectData actually useful.
- [ ] Multi-version support, currently only 1.18+ is stable.
- [ ] Make class names match the protocol specified names.

### Credits
- PacketEvents for providing the API and retrooper being a cool guy in general
- Minestom certain mappings were taken from Minestom cause i have not slept in 4 days and it was faster
