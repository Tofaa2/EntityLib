plugins {
    id("entitylib.java-conventions")
    id("entitylib.publish-conventions")
}

val codegen: Configuration by configurations.creating

dependencies {
    api(project(":api"))

    compileOnly(libs.packetevents.api)
    compileOnly(libs.bundles.adventure)

    codegen(project(":codegen"))
}

val schemaDir = rootProject.layout.projectDirectory.dir("codegen/schema")
val wrapperSources = layout.buildDirectory.dir("generated/sources/metaWrappers/java")

val generateMetaWrappers = tasks.register<JavaExec>("generateMetaWrappers") {
    group = "schema"
    description = "Generates the per version metadata wrappers from the metadata schema"
    inputs.dir(schemaDir)
    outputs.dir(wrapperSources)
    classpath = codegen
    mainClass.set("me.tofaa.entitylib.codegen.Main")
    args("generate-wrappers", "--schema", schemaDir.asFile.path, "--out", wrapperSources.get().asFile.path)
}

sourceSets {
    main {
        java.srcDir(generateMetaWrappers)
    }
}

val versionNames = Regex("name:\\s*\"([^\"]+)\"")
    .findAll(schemaDir.file("versions.yml").asFile.readText())
    .map { it.groupValues[1] }
    .toList()

versionNames.forEach { versionName ->
    val identifier = "v" + versionName.replace('.', '_')
    val packagePath = "me/tofaa/entitylib/meta/$identifier/**"

    val versionJar = tasks.register<Jar>("${identifier}Jar") {
        group = "build"
        archiveBaseName.set("meta-$identifier")
        from(sourceSets.main.get().output) {
            include(packagePath)
        }
    }

    val versionSourcesJar = tasks.register<Jar>("${identifier}SourcesJar") {
        group = "build"
        archiveBaseName.set("meta-$identifier")
        archiveClassifier.set("sources")
        from(generateMetaWrappers) {
            include(packagePath)
        }
    }

    tasks.assemble {
        dependsOn(versionJar)
    }

    publishing {
        publications {
            create<MavenPublication>(identifier) {
                artifactId = "meta-$identifier"
                artifact(versionJar)
                artifact(versionSourcesJar)
                pom {
                    name.set("${rootProject.name}-meta-$identifier")
                    withXml {
                        val dependency = asNode().appendNode("dependencies").appendNode("dependency")
                        dependency.appendNode("groupId", project.group)
                        dependency.appendNode("artifactId", "api")
                        dependency.appendNode("version", project.version)
                        dependency.appendNode("scope", "compile")
                    }
                }
            }
        }
    }
}
