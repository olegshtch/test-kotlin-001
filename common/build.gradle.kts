description = "common"

plugins {
    id("org.jetbrains.kotlin.multiplatform")
}

repositories {
    mavenCentral() 
}

kotlin {
    jvm()
    js(IR).browser()
}
