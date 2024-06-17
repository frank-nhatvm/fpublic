import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("com.vanniktech.maven.publish") version "0.27.0"
    id("maven-publish")
    signing
}

group = "com.fatherofapps"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

//mavenPublishing {
//    publishToMavenCentral(SonatypeHost.S01, automaticRelease = true)
//    coordinates(
//        groupId = "com.fatherofapps",
//        artifactId = "flib",
//        version = "1.0"
//    )
//    pom {
//        name.set("flib")
//        description.set("A library to test publish AAR file")
//        inceptionYear.set("2024")
//        url.set("https://github.com/frank-nhatvm/fpublic")
//        licenses {
//            license {
//                name.set("The Apache License, Version 2.0")
//                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
//            }
//        }
//        developers {
//            developer {
//                id.set("frank_vu")
//                name.set("Frank Vu")
//                email.set("nhat.thtb@gmail.com")
//                url.set("https://fatherofapps.com/")
//            }
//        }
//        scm {
//            url.set("https://github.com/frank-nhatvm/fpublic")
//            connection.set("scm:git@github.com:frank-nhatvm/fpublic.git")
//            developerConnection.set("scm:git@github.com:frank-nhatvm/fpublic.git")
//        }
//    }
//
//    repositories {
//        val repositoryDir = gradle.gradleUserHomeDir
//            .resolve("fpublic-repository-releases")
//            .resolve("repository")
//        maven {
//            name = "FPublicMavenReleases"
//            url = repositoryDir.resolve("releases").toURI()
//        }
//    }
//    signAllPublications()
//
//}

publishing{

    publications{
        create<MavenPublication>("fpublic"){
            groupId = "com.fatherofapps"
            artifactId = "fpublic"
            version = "1.0"
            from(components["java"])
            pom{
                name = "Flib"
                description = "A library to generate route for Jetpack Compose Navigation by using KSP"
                url = "https://github.com/frank-nhatvm/fpublic"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "frank_vu"
                        name = "Frank Vu"
                        email = "nhat.thtb@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git@github.com:frank-nhatvm/fpublic.git"
                    developerConnection = "scm:git@github.com:frank-nhatvm/fpublic.git"
                    url = "https://github.com/frank-nhatvm/fpublic"
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = "frank_vu"
                password = "my_pass_word"
            }
        }
    }
}



signing {
   // sign(publishing.publications["flib"])
}


//publishing {
//    repositories {
//        val repositoryDir = gradle.gradleUserHomeDir
//            .resolve("fpublic-repository-releases")
//            .resolve("repository")
//        maven {
//            name = "FPublicMavenReleases"
//            url = repositoryDir.resolve("releases").toURI()
//        }
//
//    }
//}