plugins {
    id("entitylib.library-conventions")
    id("entitylib.shadow-conventions")
}

dependencies {
    api(project(":api"))
    compileOnly(libs.fabric.loader)
    compileOnly(libs.packetevents.api)
}
