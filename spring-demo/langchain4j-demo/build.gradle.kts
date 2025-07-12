plugins {
    id("java")
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
    implementation("ch.qos.logback:logback-classic:1.5.18")
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