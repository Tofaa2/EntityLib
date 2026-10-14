plugins {
    id("entitylib.library-conventions")
}

dependencies {
    api(project(":addons:display"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.bundles.adventure)
}
