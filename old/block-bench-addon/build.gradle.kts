plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
}

repositories {
    maven {
        url = uri("https://mvn.lumine.io/repository/maven-public/")
    }
    maven("https://jitpack.io")
}

dependencies {
    api(project(":api"))
    compileOnly(libs.packetevents.api)
    compileOnly(libs.gson)
    implementation("commons-io:commons-io:2.11.0")
    implementation("org.zeroturnaround:zt-zip:1.8")

    implementation("javax.json:javax.json-api:1.1.4")
    implementation("org.glassfish:javax.json:1.1.4")

    implementation("com.github.hollow-cube.common:mql:2b48ad430f")
}
