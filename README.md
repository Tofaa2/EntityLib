# EntityLib  
EntityLib is a PacketEvents addon that provides an abstraction over raw entity data and packets to make it easier to work with entities as a whole.
Currently, EntityLib is only stable for 1.21.9+, but it will support all versions that PacketEvents supports in the future. <br>
For general support and reports of bugs, join the [Discord](https://discord.gg/jawR25hrSK) server.

Currently supported platforms are `spigot` and `velocity`
You can easily use EntityLib platformless by using the `api` or `common` module

If you like EntityLib and or want to sponsor me, visit my [ko-fi page](https://ko-fi.com/tofaa) :D 

EntityLib is published to [PVPHub](https://maven.pvphub.me/#/tofaa/io/github/tofaa2). Snapshots are available on pushes to the main branch, and stable releases are published on GitHub releases.
Many thanks to the team at PVP Hub and @Bram1903 for hosting EntityLib

Current Version: `3.0.3-SNAPSHOT`

Gradle (Groovy DSL):
```groovy
repositories {
    mavenCentral()
    maven("https://maven.pvphub.me/tofaa")
}

dependencies {
    implementation 'io.github.tofaa2:<platform>:<version>'
}
```

Gradle (Kotlin DSL):
```kotlin
repositories {
    mavenCentral()
    maven("https://maven.pvphub.me/tofaa")
}

dependencies {
    implementation("io.github.tofaa2:<platform>:<version>")
}
```

Maven:
```xml
<dependency>
    <groupId>io.github.tofaa2</groupId>
    <artifactId><platform></artifactId>
    <version><version></version>
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
import me.tofaa.entitylib.meta.v1_21_4.PigMeta;

class Example {

    public static void main(String[] args) {
        EntityLibPlatform platform = ;// your EntityLibPlatform implementation
        APIConfig settings = new APIConfig(PacketEvents.getAPI(), platform)
                .debugMode();

        EntityLib.init(settings);

        // Metadata is version independent, indexes and types are resolved when it is encoded for a protocol version
        int entityId = 1;
        Metadata metadata = new Metadata()
                .set(MetaFields.Entity.CUSTOM_NAME, Optional.of(Component.text("Bob")))
                .set(MetaFields.Pig.BOOST_TIME, 20)
                .setFlag(MetaFields.Entity.GLOWING, true);

        // Each version also has typed wrappers exposing exactly the fields of that version
        PigMeta pigMeta = new PigMeta(metadata);
        pigMeta.setSaddle(true);

        // Once you're done modifying the meta accordingly, you can convert it to a packet for the version of whoever should see the changes.
        int protocolVersion = User.getClientVersion().getProtocolVersion();
        WrapperPlayServerEntityMetadata metaPacket = metadata.createPacket(entityId, protocolVersion);
        User.sendPacket(metaPacket);
    }

}
```

### Creating a WrapperEntity

```java
import com.github.retrooper.packetevents.protocol.world.Location;

class Example {

    public static void main(String[] args) {
        EntityLibPlatform platform = ;// your EntityLibPlatform implementation
        APIConfig settings = new APIConfig(PacketEvents.getAPI(), platform)
                .debugMode();

        EntityLib.init(settings);

        WrapperEntity entity = new WrapperLivingEntity(entityId, UUID, EntityTypes.PIG, Location);

        // Entities send their metadata to every viewer in the viewer's own version
        entity.setMetadata(MetaFields.Pig.BOOST_TIME, 20);
        entity.setFlag(MetaFields.Entity.GLOWING, true);

        // adding a viewer to the entity can be done before or after spawn, doesnt matter
        entity.addViewer(UUID);
        entity.removeViewer(UUID);

        entity.spawn(Location); // Spawns the entity at the given location
        entity.remove(); // Removes the entity from the world
    }

}

```



### Credits
- PacketEvents for providing the API and retrooper being a cool guy in general
- Minestom certain mappings were taken from Minestom cause i have not slept in 4 days and it was faster
