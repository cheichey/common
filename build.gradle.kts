plugins {
    kotlin("jvm") version "1.6.0"
}

group = "com.github.cheatank"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.google.guava:guava:31.0.1-jre")
    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
}
