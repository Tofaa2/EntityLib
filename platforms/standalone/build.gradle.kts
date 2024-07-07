plugins {
    entitylib.`library-conventions`
    entitylib.`shadow-conventions`
}

dependencies {
    api(project(":common"))
    compileOnly(libs.packetevents.api)
}
