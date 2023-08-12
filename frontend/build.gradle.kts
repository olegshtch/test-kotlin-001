import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

description = "frontend"

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR).browser()
}
