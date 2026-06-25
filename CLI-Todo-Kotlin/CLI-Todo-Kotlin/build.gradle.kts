plugins {
    kotlin("jvm") version "2.3.21"
}

group = "com.sangeeth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.mongodb:mongodb-driver-kotlin-coroutine")

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}