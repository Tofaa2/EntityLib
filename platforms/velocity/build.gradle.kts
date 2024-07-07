plugins {
    entitylib.`java-conventions`
    id("java-library")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":common"))
    compileOnly(libs.velocity)
    compileOnly(libs.packetevents.velocity)
    annotationProcessor(libs.velocity)
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release = 17
    }
}
