plugins {
    id("java")
    entitylib.`shadow-conventions`

    entitylib.`library-conventions`
    alias(libs.plugins.run.paper)
}

group = "io.github.tofaa2"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://maven.pvphub.me/tofaa")
    maven("https://repo.codemc.io/repository/maven-releases/")
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
    compileOnly(libs.adventure.api)
    implementation(project(":platforms:spigot"))
    implementation(project(":movement-engine"))
    implementation(project(":platforms:movement"))
}

tasks {
    compileJava {
        sourceCompatibility = "21"
        targetCompatibility = "21"
        options.release.set(21)
    }
}

tasks {
    val version = "1.21.3"
    val javaVersion = JavaLanguageVersion.of(21)

//    shadowJar {
//        relocate("io.github.retrooper", "me.tofaa.npc.thirdparty.retrooper")
//        relocate("com.github.retrooper", "me.tofaa.npc.thirdparty.retrooper")
//        mergeServiceFiles()
//    }

    val packetEvents = runPaper.downloadPluginsSpec {
        modrinth("packetevents", "3Jr8ovul")
    }

    runServer {
        minecraftVersion(version)
        runDirectory = rootDir.resolve("run/paper/$version")
        javaLauncher = project.javaToolchains.launcherFor {
            languageVersion = javaVersion
        }
        downloadPlugins {
            from(packetEvents)
        }
    }
}
