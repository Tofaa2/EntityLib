plugins {
    entitylib.`java-conventions`
    id("java-library")
}

dependencies {
    api(libs.jetbrains.annotations)

    compileOnlyApi(libs.bundles.adventure)
    compileOnlyApi(libs.packetevents.api)
}
