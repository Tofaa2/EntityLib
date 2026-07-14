dependencies {
    implementation(libs.gson)
    implementation(libs.javapoet)
    implementation(libs.jetbrains.annotations)
    implementation(project(":api"))
    implementation(libs.packetevents.api)
}

tasks.register<JavaExec>("generateMetaFields") {
    description = "Generates MetaField classes from KennyTV entity data"
    mainClass.set("me.tofaa.entitylib.codegen.Main")
    classpath = sourceSets.main.get().runtimeClasspath
    workingDir = rootProject.projectDir
}
