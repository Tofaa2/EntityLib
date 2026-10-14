plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Display - groups of display entities transformed and animated as one"

dependencies {
    api(project(":api"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.bundles.adventure)
}
