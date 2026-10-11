package me.tofaa.entitylib.version

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

abstract class ELVersionTask : DefaultTask() {

    companion object {
        const val TASK_NAME = "generateVersionsFile"
        private val REGEX = Regex("""(\d+)\.(\d+)\.(\d+).*""")
    }

    @get:Input
    abstract val packageName: Property<String>

    @get:Input
    abstract val version: Property<String>

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @TaskAction
    fun generate() {
        val raw = version.get()
        val match = REGEX.matchEntire(raw) ?: throw IllegalArgumentException("Invalid version: $raw")
        val (major, minor, patch) = match.destructured
        val snapshot = raw.endsWith("-SNAPSHOT")

        val dir = outputDir.get().dir(packageName.get().replace('.', '/')).asFile
        dir.mkdirs()
        dir.resolve("ELVersions.java").writeText(
            """
            package ${packageName.get()};

            import com.github.retrooper.packetevents.util.PEVersion;

            public final class ELVersions {

                public static final String RAW = "$raw";
                public static final PEVersion CURRENT = new PEVersion($major, $minor, $patch, $snapshot);
                public static final PEVersion UNKNOWN = new PEVersion(0, 0, 0);

                private ELVersions() {
                    throw new IllegalStateException();
                }

            }
            """.trimIndent() + "\n"
        )
    }

}
