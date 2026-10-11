plugins {
    java
    id("com.gradleup.shadow")
}

tasks {
    shadowJar {
        archiveFileName = "EntityLib-${project.name}-${rootProject.version}.jar"
        mergeServiceFiles()
    }

    assemble {
        dependsOn(shadowJar)
    }
}

plugins.withId("maven-publish") {
    val javaComponent = components["java"] as AdhocComponentWithVariants
    javaComponent.withVariantsFromConfiguration(configurations["shadowRuntimeElements"]) {
        skip()
    }
}
