plugins {
    id("entitylib.library-conventions")
    id("entitylib.shadow-conventions")
    id("el-version")
}

val codegen: Configuration by configurations.creating

dependencies {
    api(libs.jetbrains.annotations)

    compileOnly(libs.packetevents.api)
    compileOnly(libs.bundles.adventure)
    compileOnly(libs.gson)

    codegen(project(":codegen"))
}

val schemaDir = rootProject.layout.projectDirectory.dir("codegen/schema")

val generateMetaFields = tasks.register<JavaExec>("generateMetaFields") {
    group = "schema"
    description = "Generates MetaFields from the metadata schema"
    val output = layout.buildDirectory.dir("generated/sources/metaFields/java")
    inputs.dir(schemaDir)
    outputs.dir(output)
    classpath = codegen
    mainClass.set("me.tofaa.entitylib.codegen.Main")
    args("generate-fields", "--schema", schemaDir.asFile.path, "--out", output.get().asFile.path)
}

sourceSets {
    main {
        java.srcDir(generateMetaFields)
    }
}

tasks.named<me.tofaa.entitylib.version.ELVersionTask>("generateVersionsFile") {
    packageName = "me.tofaa.entitylib.utils"
}
