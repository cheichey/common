plugins {
    kotlin("jvm") version "1.6.0"
    id("org.jmailen.kotlinter") version "3.7.0"
    id("com.github.ben-manes.versions") version "0.39.0"
}

group = "com.github.cheatank"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("reflect"))
}
