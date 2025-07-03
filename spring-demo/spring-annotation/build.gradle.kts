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

    // https://mvnrepository.com/artifact/org.springframework/spring-context
    implementation("org.springframework:spring-context:6.2.8")

    // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
    implementation("org.aspectj:aspectjweaver:1.9.24")

    // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    // https://mvnrepository.com/artifact/javax.inject/javax.inject
    implementation("javax.inject:javax.inject:1")

    // https://mvnrepository.com/artifact/com.mchange/c3p0
    implementation("com.mchange:c3p0:0.11.1")

    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:9.3.0")

    // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
    implementation("org.aspectj:aspectjweaver:1.9.24")

    // https://mvnrepository.com/artifact/org.springframework/spring-aop
    implementation("org.springframework:spring-aop:6.2.8")

    // https://mvnrepository.com/artifact/cn.hutool/hutool-all
    implementation("cn.hutool:hutool-all:5.8.38")
}

tasks.test {
    useJUnitPlatform()

    systemProperties["os.name"]="linux"
    systemProperties["spring.profiles.active"]="test"
}


