plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
}

dependencies {
    api(project(":api"))
    compileOnly(libs.bundles.adventure)
    compileOnly(libs.packetevents.api)
}
