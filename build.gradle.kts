plugins {
    id("java")
    id("java-library")
    id("maven-publish")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    group = "me.tofaa.entitylib"
    description = rootProject.name
    version = "2.4.1-SNAPSHOT"

    java.sourceCompatibility = JavaVersion.VERSION_1_8
    java.targetCompatibility = JavaVersion.VERSION_1_8

    java {
        withSourcesJar()
        withJavadocJar()
    }

    repositories {
        mavenCentral()
        maven {
            url = uri("https://jitpack.io/")
        }
        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
        maven {
            name = "codemc-repo"
            url = uri("https://repo.codemc.io/repository/maven-releases/")
        }
        maven {
            url = uri("https://oss.sonatype.org/content/groups/public/")
        }
        maven {
            url = uri("https://repo.codemc.org/repository/maven-public/")
        }
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
                from(components["java"])
            }
        }
    }
}

dependencies {
    compileOnlyApi(libs.packetevents.spigot)
}
