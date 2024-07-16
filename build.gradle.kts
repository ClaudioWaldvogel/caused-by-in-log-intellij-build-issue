import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    groovy
}

group = "com.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    useJUnitPlatform()
    options {
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }
    testLogging {
        events("skipped", "failed")
        exceptionFormat = TestExceptionFormat.FULL
        showCauses = true
        showExceptions = true
        showStackTraces = true
        showStandardStreams = true // This setting forces gradle build to be visualized as error
    }
}

dependencies {
    implementation("org.apache.groovy:groovy:4.0.14")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation(platform("org.apache.groovy:groovy-bom:4.0.22"))
    testImplementation(platform("org.spockframework:spock-bom:2.4-M4-groovy-4.0"))
    testImplementation("net.bytebuddy:byte-buddy:1.14.17")
    testImplementation("org.apache.groovy:groovy:4.0.22")
    testImplementation("org.spockframework:spock-core")
}

tasks.test {
    useJUnitPlatform()
}
