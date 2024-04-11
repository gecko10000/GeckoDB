plugins {
    kotlin("jvm") version "1.9.22"
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "gecko10000.geckodb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(kotlin("stdlib", version = "1.9.22"))

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    api("org.jetbrains.xodus:xodus-openAPI:2.0.1")
    api("org.jetbrains.xodus:xodus-environment:2.0.1")
    api("org.jetbrains.xodus:xodus-entity-store:2.0.1")
    compileOnly("org.apache.logging.log4j:log4j-core:2.23.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks {
    build {
        dependsOn(publishToMavenLocal, shadowJar)
    }
}

sourceSets {
    main {
        java {
            srcDir("src")
        }
        resources {
            srcDir("res")
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("local") {
            from(components["java"])
            artifactId = "GeckoDB"
        }
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.register("update") {
    dependsOn(tasks.build)
    doLast {
        exec {
            workingDir(".")
            commandLine("./update.sh")
        }
    }
}
