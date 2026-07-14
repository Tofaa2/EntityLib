plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
}

dependencies {
    api(project(":common"))
    compileOnly(libs.packetevents.api)
}
