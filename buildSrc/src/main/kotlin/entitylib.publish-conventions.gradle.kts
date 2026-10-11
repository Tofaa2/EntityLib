plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "pvphub-maven-tofaa"
            url = uri("https://maven.pvphub.me/tofaa")
            credentials {
                username = System.getenv("PVPHUB_MAVEN_USERNAME")
                password = System.getenv("PVPHUB_MAVEN_SECRET")
            }
        }
    }

    publications.withType<MavenPublication>().configureEach {
        groupId = rootProject.group as String
        version = rootProject.version as String

        pom {
            description = rootProject.description
            url = "https://github.com/Tofaa2/EntityLib"

            licenses {
                license {
                    name = "GPL-3.0"
                    url = "https://www.gnu.org/licenses/gpl-3.0.html"
                }
            }

            developers {
                developer {
                    id = "Tofaa2"
                    name = "Tofaa"
                    email = "tofaadev@gmail.com"
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
