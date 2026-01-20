plugins {
    `kotlin-dsl`
}

kotlin {
    compilerOptions {
        jvmToolchain(21)
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.shadow)
}