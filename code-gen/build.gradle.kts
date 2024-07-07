plugins {
    entitylib.`java-conventions`
}

dependencies {
    implementation(libs.gson)
    implementation(libs.javapoet)
    implementation(libs.packetevents.api)
    implementation(libs.jetbrains.annotations)
}
