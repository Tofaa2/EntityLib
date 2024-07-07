plugins {
    entitylib.`java-conventions`
    `java-library`
    `el-version`
}

dependencies {
    api(libs.jetbrains.annotations)

    compileOnlyApi(libs.bundles.adventure)
    compileOnlyApi(libs.packetevents.api)
}

tasks {
    generateVersionsFile {
        packageName = "me.tofaa.entitylib.utils"
    }
}
