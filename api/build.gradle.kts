plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
    `el-version`
}

dependencies {
    api(libs.jetbrains.annotations)

    compileOnly(libs.bundles.adventure)
    compileOnly(libs.packetevents.api)
    testCompileOnly(libs.packetevents.api)
}

tasks {
    javadoc {
        mustRunAfter(generateVersionsFile)
    }

    sourcesJar {
        mustRunAfter(generateVersionsFile)
    }

    withType<JavaCompile> {
        dependsOn(generateVersionsFile)
    }

    generateVersionsFile {
        packageName = "me.tofaa.entitylib.utils"
    }
}
