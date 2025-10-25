import java.io.ByteArrayOutputStream

val fullVersion = "3.0.3"
val snapshot = true

group = "io.github.tofaa2"
description = rootProject.name

fun getVersionMeta(includeHash: Boolean): String {
    if (!snapshot) {
        return ""
    }
    var commitHash = ""
    if (includeHash && file(".git").isDirectory) {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
        commitHash = "+${stdout.toString().trim()}"
    }
    return "$commitHash-SNAPSHOT"
}
version = "$fullVersion${getVersionMeta(true)}"
ext["versionBeta"] = getVersionMeta(true)
ext["versionNoHash"] = "$fullVersion${getVersionMeta(false)}"

tasks {
    wrapper {
        gradleVersion = "8.8"
        distributionType = Wrapper.DistributionType.ALL
    }

    fun subModuleTasks(taskName: String): List<Task> {
        return subprojects
            .filter { it.name != "platforms" }
            .mapNotNull { it.tasks.findByName(taskName) }
    }

    register("build") {
        val subModuleBuildTasks = subModuleTasks("build")
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

    register("publishAllPublicationsToMavenRepository") {
        val publishTasks = subModuleTasks("publishAllPublicationsToMavenRepository")
        dependsOn(publishTasks)
        group = "publishing"
    }

    register<Delete>("clean") {
        val cleanTasks = subModuleTasks("clean")
        dependsOn(cleanTasks)
        group = "build"
        delete(rootProject.layout.buildDirectory)
    }

    defaultTasks("build")
}
