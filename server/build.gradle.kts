import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "com.trunkofficial"
version = "0.0.1-SNAPSHOT"

val kotestVersion = "4.3.2"
val mockkVersion = "1.10.0"

dependencies {
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//    runtimeOnly("com.h2database:h2")
//    runtimeOnly("io.r2dbc:r2dbc-h2")

    implementation("mysql:mysql-connector-java")
    implementation("dev.miku:r2dbc-mysql")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
}

val bootJar: BootJar by tasks
bootJar.enabled = true