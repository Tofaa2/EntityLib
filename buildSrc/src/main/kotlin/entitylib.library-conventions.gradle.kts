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
        create<MavenPublication>("shadow") {
            groupId = project.group as String
            artifactId = project.name
            version = project.version as String

            if (isShadow) {
                artifact(project.tasks.withType<ShadowJar>().getByName("shadowJar").archiveFile)

                val allDependencies = project.provider {
                    project.configurations.getByName("shadow").allDependencies
                        .filter { it is ProjectDependency || it !is SelfResolvingDependency }
                }

                pom {
                    withXml {
                        val (libraryDeps, projectDeps) = allDependencies.get().partition { it !is ProjectDependency }
                        val dependenciesNode = asNode().get("dependencies") as? Node ?: asNode().appendNode("dependencies")

                        libraryDeps.forEach {
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                            dependencyNode.appendNode("scope", "compile")
                        }

                        projectDeps.forEach {
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", "packetevents-" + it.name)
                            dependencyNode.appendNode("version", it.version)
                            dependencyNode.appendNode("scope", "compile")
                        }
                    }
                }

                artifact(tasks["sourcesJar"])
            } else {
                from(components["java"])
            }

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