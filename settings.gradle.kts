pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver") version "0.8.0"
}

toolchainManagement {
    jvm {
        javaRepositories {
            repository("foojay") {
                resolverClass.set(org.gradle.toolchains.foojay.FoojayToolchainResolver::class.java)
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
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
