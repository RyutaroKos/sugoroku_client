plugins {
    id("buildSrc")
}

dependencies {
    implementation(projects.data)
    implementation("org.glassfish.tyrus:tyrus-container-grizzly-client:2.0.1")
}