plugins {
    entitylib.`library-conventions`
    entitylib.`shadow-conventions`
}

dependencies {
    implementation(libs.gson)
    implementation(libs.javapoet)
    implementation(libs.packetevents.api)
    implementation(libs.jetbrains.annotations)
}
