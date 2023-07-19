plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mockito:mockito-inline:5.2.0")
    implementation("org.mockito:mockito-core:5.2.0")
    implementation("org.mockito:mockito-core:5.2.0")
    implementation("org.mockito:mockito-subclass:5.2.0")
    implementation("org.mockito:mockito-subclass:5.2.0")
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.mockito:mockito-core:5.2.0")
}

tasks.test {
    useJUnitPlatform()
}