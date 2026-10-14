plugins {
    id("entitylib.java-conventions")
    id("entitylib.shadow-conventions")
    alias(libs.plugins.run.paper)
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
    implementation(project(":platforms:spigot"))
    implementation(project(":meta-versions"))
    implementation(project(":addons:block-bench"))
    implementation(project(":addons:display"))
    implementation(project(":addons:shapes"))
    implementation(project(":addons:structures"))
    implementation(project(":addons:gui"))
}

tasks {
    val packetEvents = runPaper.downloadPluginsSpec {
        modrinth("packetevents", "m78nFxYg")
    }

    runServer {
        minecraftVersion("1.21.3")
        runDirectory = rootDir.resolve("run/paper/1.21.3")
        jvmArgs = listOf("-Dcom.mojang.eula.agree=true")
        downloadPlugins {
            from(packetEvents)
        }
    }
}
