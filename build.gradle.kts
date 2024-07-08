import java.io.ByteArrayOutputStream

plugins {
    entitylib.`library-conventions`
}

group = "me.tofaa.entitylib"
description = rootProject.name
val fullVersion = "2.4.1"
val snapshot = true

fun getVersionMeta(): String {
    if (!snapshot) {
        return ""
    }
    var commitHash = ""
    if (file(".git").isDirectory) {
        val stdout = ByteArrayOutputStream()
        exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
        commitHash = "+${stdout.toString().trim()}"
    }
    return "$commitHash-SNAPSHOT"
}
version = "$fullVersion${getVersionMeta()}"