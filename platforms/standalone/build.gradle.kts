plugins {
    entitylib.`java-conventions`
    `java-library`
}

dependencies {
    api(project(":common"))
    compileOnly(libs.packetevents.api)
}
