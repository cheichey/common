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
        jvm {
        }
        js(IR) {
            browser()
        }
    }
}

val sourceJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}
