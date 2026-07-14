plugins {
    entitylib.`library-conventions`
}

description = "EntityLib Movement Platform - Spigot implementation"

repositories {
    maven("https://maven.pvphub.me/tofaa")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":movement-engine"))
}
