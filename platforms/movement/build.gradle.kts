plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Movement Platform - Spigot implementation"

dependencies {
    api(project(":addons:movement-engine"))
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
}
