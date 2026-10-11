plugins {
    `java-library`
}

group = rootProject.group
version = rootProject.version

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
    }

    withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
        (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching(listOf("plugin.yml", "velocity-plugin.json", "fabric.mod.json")) {
            expand("version" to project.version)
        }
    }
}
