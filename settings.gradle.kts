
rootProject.name = "fpublic"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            name = "fpublic-repository-releases"
            setUrl("https://raw.githubusercontent.com/frank-nhatvm/fpublic/main/repository/releases")
        }
    }
}

