plugins {
    id("buildSrc")
    id("application")
}

application {
    mainModule.set("client.app.app.main")
    mainClass.set("com.example.app.App")
}

dependencies {
    implementation(projects.ui)
    implementation(projects.data)
    implementation(projects.netcom)
}