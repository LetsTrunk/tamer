import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("plugin.jpa")
    kotlin("kapt")
}

group = "com.tamerofficial"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
    kapt("com.querydsl:querydsl-apt:4.4.0:general")
    implementation("com.querydsl:querydsl-jpa:4.4.0")
}

val bootJar: BootJar by tasks
bootJar.enabled = false