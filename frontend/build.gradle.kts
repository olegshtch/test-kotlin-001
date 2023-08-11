import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

description = "frontend"

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    js(IR).browser()
}
