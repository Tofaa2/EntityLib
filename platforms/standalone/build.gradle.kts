plugins {
    id("entitylib.library-conventions")
    id("entitylib.shadow-conventions")
}

dependencies {
    api(project(":api"))
    compileOnly(libs.packetevents.api)
}
