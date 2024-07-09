plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
    `el-version`
}

dependencies {
    api(libs.jetbrains.annotations)

    compileOnlyApi(libs.bundles.adventure)
    compileOnlyApi(libs.packetevents.api)
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
