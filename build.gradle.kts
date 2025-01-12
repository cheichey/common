plugins {
    kotlin("multiplatform") version "1.6.0"
    id("org.jmailen.kotlinter") version "3.7.0"
    id("com.github.ben-manes.versions") version "0.39.0"
    `maven-publish`
}

group = "com.github.cheatank"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
    }
    js(IR) {
        browser()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("reflect"))
            }
        }
    }
}
