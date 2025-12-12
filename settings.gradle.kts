pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver") version "1.0.0"
}

rootProject.name = "EntityLib"
include(":common")
include(":api")
include(":platforms:spigot")
include(":platforms:velocity")
include(":platforms:standalone")

if (System.getenv("PRIVATE").toBoolean()) {
    include("discord-bot")
    include(":code-gen")
    include(":test-plugin")
    include(":block-bench-addon")
}
