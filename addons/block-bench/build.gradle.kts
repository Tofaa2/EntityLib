plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Block Bench - native .bbmodel parser and display entity models"

dependencies {
    api(project(":addons:display"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.gson)
}
