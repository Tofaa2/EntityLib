plugins {
    id("entitylib.library-conventions")
}

description = "EntityLib Block Bench - native .bbmodel parser and display entity models"

dependencies {
    api(project(":api"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.gson)
}
