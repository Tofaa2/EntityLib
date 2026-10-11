plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Movement Platform - Spigot implementation"

dependencies {
    api(project(":movement-engine"))
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
}
