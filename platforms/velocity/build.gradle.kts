
repositories {
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

tasks {
    compileJava {
        options.release.set(17)
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))


dependencies {
    api(project(":common"))
    compileOnly(libs.velocity)
    compileOnly(libs.packetevents.velocity)
    annotationProcessor(libs.velocity)
}
