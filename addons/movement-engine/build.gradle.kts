plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Movement Engine - Pathfinding and movement for WrapperEntities"

dependencies {
    api(project(":api"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.adventure.api)
}
