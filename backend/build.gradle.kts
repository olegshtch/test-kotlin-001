import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "backend"

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.spring") version "1.9.10"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral() 
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(project(":common"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        resources {
            project(":frontend").afterEvaluate {
                srcDir(this.tasks.getByName("jsBrowserDistribution"))
            }
        }
    }
}

tasks {
    processResources {
        eachFile {
            relativePath = relativePath.prepend("static")
        }
    }
}
