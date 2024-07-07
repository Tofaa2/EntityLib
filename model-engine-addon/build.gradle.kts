repositories {
    maven {
        url = uri("https://mvn.lumine.io/repository/maven-public/")
    }
}

dependencies {
    // compileOnly("com.ticxo.modelengine:ModelEngine:R4.0.4")
    api(project(":api"))
}
