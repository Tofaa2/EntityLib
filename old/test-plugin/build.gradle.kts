plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
    alias(libs.plugins.run.paper)
}

repositories {
    maven("https://maven.evokegames.gg/snapshots")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
    implementation(project(":platforms:spigot"))
//    implementation(project(":platforms:spigot"))
}

tasks {
    val version = "1.21.3"
    val javaVersion = JavaLanguageVersion.of(21)

    val jvmArgsExternal = listOf(
        "-Dcom.mojang.eula.agree=true"
    )

    val sharedBukkitPlugins = runPaper.downloadPluginsSpec {
        modrinth("packetevents", "3Jr8ovul")
    }

    runServer {
        minecraftVersion(version)
        runDirectory = rootDir.resolve("run/paper/$version")

        javaLauncher = project.javaToolchains.launcherFor {
            languageVersion = javaVersion
        }

        downloadPlugins {
            from(sharedBukkitPlugins)
        }

        jvmArgs = jvmArgsExternal
    }

    runPaper.folia.registerTask {
        minecraftVersion(version)
        runDirectory = rootDir.resolve("run/folia/$version")

        javaLauncher = project.javaToolchains.launcherFor {
            languageVersion = javaVersion
        }

        downloadPlugins {
            from(sharedBukkitPlugins)
        }

        jvmArgs = jvmArgsExternal
    }
}
