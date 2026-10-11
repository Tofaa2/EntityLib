plugins {
    id("entitylib.java-conventions")
    id("entitylib.publish-conventions")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("EntityLib") {
            artifactId = project.name
            from(components["java"])
            pom.name = "${rootProject.name}-${project.name}"
        }
    }
}
