plugins {
    java
    com.gradleup.shadow
}

tasks {
    shadowJar {
        archiveFileName = "EntityLib-${project.name}-${rootProject.ext["versionNoHash"]}.jar"
        archiveClassifier = null

        mergeServiceFiles()
    }

    assemble {
        dependsOn(shadowJar)
    }
}

configurations.implementation.get().extendsFrom(configurations.shadow.get())