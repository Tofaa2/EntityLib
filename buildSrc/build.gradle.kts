plugins {
    `kotlin-dsl`
}

kotlin {
    compilerOptions {
        jvmToolchain(8)
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.shadow)
}