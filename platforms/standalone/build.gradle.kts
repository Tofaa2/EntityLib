plugins {
    entitylib.`java-conventions`
    id("java-library")
}

dependencies {
    api(project(":common"))
    compileOnly(libs.packetevents.api)
}
