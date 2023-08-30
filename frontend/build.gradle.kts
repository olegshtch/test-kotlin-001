description = "frontend"

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        browser()
    }.binaries.executable()

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("dev.fritz2:core:1.0-RC10")
                implementation(project(":common"))
            }
        }
    }
}
