package me.tofaa.entitylib.version

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.register

class ELVersionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val task = target.tasks.register<ELVersionTask>(ELVersionTask.TASK_NAME) {
            group = target.rootProject.name
            version.convention(target.provider { target.version.toString() })
            outputDir.convention(target.layout.buildDirectory.dir("generated/sources/version/java"))
        }

        target.plugins.withId("java") {
            val sourceSets = target.extensions.getByName<SourceSetContainer>("sourceSets")
            sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME).java.srcDir(task)
        }
    }

}
