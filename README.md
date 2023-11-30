# EntityLib
EntityLib is a PacketEvents addon that provides an abstraction over raw entity data and packets to make it easier to work with entities as a whole.

```groovy
//https://jitpack.io/#Tofaa2/EntityLib/
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Tofaa2:EntityLib:<release-tag-here>'
}
```


## Features
- Full EntityMeta support
- Creation of WrapperEntities
- Keeping track of entities.



## Usage

For more realistic examples, please take a look at the `test-plugin` module. It has an example `Bukkit` plugin that uses EntityLib.

### Using the EntityMeta api

```java
import java.sql.Wrapper;

class Example {

    public static void main(String[] args) {
        PacketEventsAPI api = ;// create PacketEventsAPI instance
        EntityLib.init(api); // If failed, it will throw an exception.

        // Making a random entity using packet events raw, i strongly recommend using the EntityLib#createEntity method instead
        int entityID = 1;
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(constructor args);
        EntityMeta meta = EntityLib.createMeta(entityId, EntityType);
        // You can cast the meta to the correct type depending on the entity type
        PigMeta pigMeta = (PigMeta) meta;

        // Once you're done modifying the meta accordingly, you can convert it to a packet, and send it to whoever you want for them  to see the changes.
        WrapperPlayServerEntityMetadata metaPacket = meta.createPacket();
        User.sendPacket(metaPacket);;
    }

}
```

### Creating a WrapperEntity

```java
import javax.xml.stream.Location;

class Example {

    public static void main(String[] args) {
        PacketEventsAPI api = ;// create PacketEventsAPI instance
        EntityLib.init(api); // If failed, it will throw an exception.

        WrapperEntity entity = EntityLib.createEntity(UUID, EntityType);
        // You can keep track of the entity yourself or store its entityId or uuid and fetch it using EntityLib#getEntity

        // Handling entity interactions if needed
        // By default EntityLib will ignore interaction packets and not handle them. You can enable this if needed
        EntityLib.enableEntityInteractions(); // Now we need to create an interaction handler
        EntityLib.setInteractionProcessor(EntityInteractionProcessor);


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
        
        // If the entityId provider for WrapperEntities is not working for you or needs changing, you can get it from WrapperEntity#ID_PROVIDER
        // You can also set it to a custom provider if needed
        WrapperEntity.ID_PROVIDER = new EntityIdProvider() {
            @Override
            public int provide() {
                return 0;
            }
        };
        
        // You can also create the EntityLib default provider by calling EntityIdProvider.simple();
    }

}

```

### TODO:
Once this list is complete, i will release a stable version of the library.
- [ ] Implement checks for each EntityMeta to make sure the version specific data is correct.
- [ ] Verify all the EntityMeta packets are working correctly.
- [ ] WrapperEntities must seamlessly send packet updates to viewers, currently they are not.
- [ ] Add support for more actions using WrapperEntities.
- [ ] More javadocs.
- [ ] Make ObjectData actually useful.
- [ ] Multi-version support
- [ ] Make class names match the protocol specified names.

### Credits
- PacketEvents for providing the API and retrooper being a cool guy in general
- Minestom certain mappings were taken from Minestom cause i have not slept in 4 days and it was faster