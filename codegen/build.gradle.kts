plugins {
    id("entitylib.java-conventions")
}

dependencies {
    implementation(libs.gson)
    implementation(libs.javapoet)
    implementation(libs.snakeyaml)
}

fun schemaTask(name: String, description: String, vararg arguments: String, configure: JavaExec.() -> Unit = {}) =
    tasks.register<JavaExec>(name) {
        group = "schema"
        this.description = description
        mainClass.set("me.tofaa.entitylib.codegen.Main")
        classpath = sourceSets.main.get().runtimeClasspath
        workingDir = rootProject.projectDir
        args(*arguments)
        configure()
    }

val schemaCheck = schemaTask("schemaCheck", "Validates the schema and verifies it against all snapshots", "check") {
    inputs.dir("schema")
    inputs.dir("snapshots")
}

schemaTask("schemaImport", "Rebuilds the entity files from the snapshots, keeping hand written parts", "import")

schemaTask("schemaUpdate", "Fetches the snapshot of -Pmc=<version> and imports it", "update") {
    doFirst {
        args(providers.gradleProperty("mc").orNull ?: throw GradleException("Pass the version with -Pmc=<version>"))
    }
}

schemaTask("schemaLayout", "Prints the indexes of -Pmc=<version>, optionally only -Pentity=<class>", "layout") {
    doFirst {
        args(providers.gradleProperty("mc").orNull ?: throw GradleException("Pass the version with -Pmc=<version>"))
        providers.gradleProperty("entity").orNull?.let { args(it) }
    }
}

tasks.named("check") {
    dependsOn(schemaCheck)
}
