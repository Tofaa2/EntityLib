plugins {
    entitylib.`library-conventions`
}

description = "EntityLib Movement Engine - Pathfinding and movement for WrapperEntities"

repositories {
    maven("https://maven.pvphub.me/tofaa")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.packetevents.spigot)
    compileOnly(libs.adventure.api)
    compileOnly(libs.paper)
    api(project(":api"))
    implementation(project(":common"))
}
