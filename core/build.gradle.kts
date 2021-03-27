import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "com.tamerofficial"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("mysql:mysql-connector-java")
    implementation("dev.miku:r2dbc-mysql")
}

val bootJar: BootJar by tasks
bootJar.enabled = false