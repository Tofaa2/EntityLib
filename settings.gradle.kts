pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.codemc.io/repository/maven-releases/")
        maven("https://repo.codemc.io/repository/maven-snapshots/")
        maven("https://maven.fabricmc.net/")
    }
}

rootProject.name = "EntityLib"
include(":api")
include(":codegen")
include(":meta-versions")
include(":platforms:spigot")
include(":platforms:velocity")
include(":platforms:standalone")
include(":platforms:fabric")
include(":addons:movement-engine")
include(":platforms:movement")
include(":addons:block-bench")
include(":addons:display")
include(":addons:shapes")
include(":addons:structures")
include(":addons:gui")
include(":test-plugin")
