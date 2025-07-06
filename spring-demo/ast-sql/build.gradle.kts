plugins {
    java
    id("org.springframework.boot") version "3.3.1" // Spring Boot 插件
    id("io.spring.dependency-management") version "1.1.6" // 依赖管理插件
    kotlin("jvm") version "1.9.20" // 添加 Kotlin JVM 插件，根据您的Kotlin版本调整
    kotlin("plugin.spring") version "1.9.20" // 添加 Kotlin Spring 插件
}

group = "icu.xiamu"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21) // 推荐使用Java 17或更高版本
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter")
    // Spring Boot Starter for JDBC (MyBatis 需要)
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    // MySQL 驱动
    // runtimeOnly("com.mysql:mysql-connector-j")

    // https://mvnrepository.com/artifact/com.dameng/DmJdbcDriver18
    runtimeOnly("com.dameng:DmJdbcDriver18:8.1.3.140")

    // Kotlin 运行时库
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // MyBatis Spring Boot Starter
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")

    // 单元测试
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test") // Kotlin 测试库

    // JSQLParser - SQL解析库
    implementation("com.github.jsqlparser:jsqlparser:4.8") // 使用最新稳定版本
}

tasks.test {
    useJUnitPlatform()
}