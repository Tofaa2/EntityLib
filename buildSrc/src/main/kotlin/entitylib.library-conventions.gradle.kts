import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import groovy.util.Node

plugins {
    `java-library`
    `maven-publish`
}

group = rootProject.group
version = rootProject.version
description = project.description

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.codemc.io/repository/maven-releases/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
}

val isShadow = project.pluginManager.hasPlugin("io.github.goooler.shadow")

java {
    withSourcesJar()
    withJavadocJar()
    disableAutoTargetJvm()

    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release = 8
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching(listOf("plugin.yml", "velocity-plugin.json")) {
            expand("version" to project.version)
        }
    }

    jar {
        archiveClassifier = "default"
    }

    defaultTasks("build")
}

publishing {
    publications {
        create<MavenPublication>("EntityLib") {
            groupId = project.group as String
            artifactId = project.name
            version = rootProject.ext["versionNoHash"] as String
            from(components["java"])

            pom {
                name = "${rootProject.name}-${project.name}"
                description = rootProject.description
                url = "https://github.com/Tofaa2/EntityLib"

                licenses {
                    license {
                        name = "GPL-3.0"
                        url = "https://www.gnu.org/licenses/gpl-3.0.html"
                    }
                }

                scm {
                    connection = "scm:git:https://github.com/Tofaa2/EntityLib.git"
                    developerConnection = "scm:git:https://github.com/Tofaa2/EntityLib.git"
                    url = "https://github.com/Tofaa2/EntityLib"
                }
            }
        }
    }
}

// So that SNAPSHOT is always the latest SNAPSHOT
configurations.all {
    resolutionStrategy.cacheDynamicVersionsFor(0, TimeUnit.SECONDS)
}

val taskNames = gradle.startParameter.taskNames
if (taskNames.any { it.contains("build") }
    && taskNames.any { it.contains("publish") }) {
    throw IllegalStateException("Cannot build and publish at the same time.")
}