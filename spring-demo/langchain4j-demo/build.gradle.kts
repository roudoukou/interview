plugins {
    id("java")
    id("org.springframework.boot") version "3.3.1" // Spring Boot 插件
    id("io.spring.dependency-management") version "1.1.6"
}

group = "icu.xiamu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/dev.langchain4j/langchain4j-open-ai
    implementation("dev.langchain4j:langchain4j-open-ai:1.1.0")
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    // implementation("ch.qos.logback:logback-classic:1.5.18")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("dev.langchain4j:langchain4j-open-ai-spring-boot-starter:1.1.0-beta7")
    // Spring Boot Starter
    implementation("org.springframework.boot:spring-boot-starter")
    // 单元测试
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // 单元测试
    implementation("org.springframework.boot:spring-boot-starter-web")
    // https://mvnrepository.com/artifact/dev.langchain4j/langchain4j-spring-boot-starter
    implementation("dev.langchain4j:langchain4j-spring-boot-starter:1.0.1-beta6")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("dev.langchain4j:langchain4j-reactor:1.0.1-beta6")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("dev.langchain4j:langchain4j-easy-rag:1.0.1-beta6")
    implementation("dev.langchain4j:langchain4j-document-parser-apache-pdfbox:1.1.0-beta7")
    implementation("org.apache.pdfbox:pdfbox:2.0.27")
    implementation("org.apache.pdfbox:fontbox:2.0.27")
    implementation("dev.langchain4j:langchain4j-community-redis-spring-boot-starter:1.0.1-beta6")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok") // 如果你使用IDE的注解处理器，这个通常是必须的
    testAnnotationProcessor("org.projectlombok:lombok") // 单元测试也需要

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")

    implementation("com.mysql:mysql-connector-j")

}

tasks.test {
    // systemProperties["file.encoding"] = "utf-8"
    useJUnitPlatform()
}

// tasks.withType<JavaCompile> {
//     options.encoding = "UTF-8"
// }

// tasks.withType<Test> {
//     jvmArgs("-Dfile.encoding=UTF-8")
// }

// tasks.withType(JavaCompile::class.java) {
//     options.encoding = "UTF-8"
// }

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Dsun.stdout.encoding=UTF-8")
}