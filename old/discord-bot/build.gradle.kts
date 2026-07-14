plugins {
    entitylib.`shadow-conventions`
    entitylib.`library-conventions`
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

dependencies {
    implementation("net.dv8tion:JDA:5.2.0")
    implementation("ch.qos.logback:logback-classic:1.4.12")

    implementation("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
}