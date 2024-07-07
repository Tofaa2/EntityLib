dependencies {
    api(project(":common"))
    compileOnly(libs.paper)
    compileOnly(libs.packetevents.spigot)
}

java {
    disableAutoTargetJvm()
}
