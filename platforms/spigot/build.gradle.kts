plugins {
    entitylib.`java-conventions`
    id("java-library")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":common"))
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
}
