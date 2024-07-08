import java.io.ByteArrayOutputStream

group = "me.tofaa.entitylib"
description = rootProject.name
val fullVersion = "2.4.1"
val snapshot = true

fun getVersionMeta(): String {
    if (!snapshot) {
        return ""
    }
    var commitHash = ""
    if (file(".git").isDirectory) {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
        commitHash = "+${stdout.toString().trim()}"
    }
    return "$commitHash-SNAPSHOT"
}
version = "$fullVersion${getVersionMeta()}"

tasks {
    wrapper {
        gradleVersion = "8.8"
        distributionType = Wrapper.DistributionType.ALL
    }

    register("build") {
        // Filter out the 'platforms' directory itself, but include its subprojects
        val subModuleBuildTasks = subprojects
            .filter { it.name != "platforms" }
            .mapNotNull { it.tasks.findByName("build") }

        dependsOn(subModuleBuildTasks)
        group = "build"

        doLast {
            val buildOut = project.layout.buildDirectory.dir("libs").get().asFile.apply {
                if (!exists()) mkdirs()
            }

            subprojects.forEach { subproject ->
                val subIn = subproject.layout.buildDirectory.dir("libs").get().asFile
                if (subIn.exists()) {
                    copy {
                        from(subIn) {
                            include("EntityLib-*.jar")
                            exclude("*-javadoc.jar", "*-sources.jar")
                        }
                        into(buildOut)
                    }
                }
            }
        }
    }

    register<Delete>("clean") {
        val cleanTasks = subprojects
            .filter { it.name != "platforms" }
            .mapNotNull { it.tasks.findByName("clean") }

        dependsOn(cleanTasks)
        group = "build"
        delete(rootProject.layout.buildDirectory)
    }

    defaultTasks("build")
}
