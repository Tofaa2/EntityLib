plugins {
    entitylib.`library-conventions`
    entitylib.`shadow-conventions`
    application
}

tasks.withType<JavaCompile> {
    options.release.set(21)
}

dependencies {
    //implementation(project(":api"))
    implementation(libs.packetevents.api)
    implementation(libs.adventure.api)
    implementation(libs.gson)
}

application {
    mainClass.set("me.tofaa.entitylib.codegen.EntityFieldsCodeGen")
}

tasks.register("prepareKotlinBuildScriptModel") {}