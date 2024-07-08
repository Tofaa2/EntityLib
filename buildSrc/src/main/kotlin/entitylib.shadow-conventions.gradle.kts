plugins {
    java
    io.github.goooler.shadow
}

tasks {
    shadowJar {
        archiveFileName = "EntityLib-${project.name}-${project.version}.jar"
        archiveClassifier = null

        mergeServiceFiles()
    }

    assemble {
        dependsOn(shadowJar)
    }
}

configurations.implementation.get().extendsFrom(configurations.shadow.get())