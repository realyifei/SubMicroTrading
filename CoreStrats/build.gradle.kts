plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    // Common libraries from Core/exlib
    implementation(files("../Core/exlib/jars/jmxtools.jar"))
    implementation(files("../Core/exlib/jars/log4j-1.2.16.jar"))
    implementation(files("../Core/exlib/jars/javax.mail.jar"))
    implementation(files("../Core/exlib/jars/xercesImpl.jar"))
    implementation(files("../Core/exlib/jars/xml-apis.jar"))
    // Add other specific JARs from Core/exlib/jars if CoreStrats needs them

    // Project dependencies (adjust if necessary)
    implementation(project(":Core"))
    implementation(project(":Generated")) 
    implementation(project(":OM")) // CoreStrats might depend on OM
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
        resources {
            srcDirs("config", "data")
        }
    }
}

// tasks.withType<Test> { // No tests, so this is not needed
//     useJUnit()
//     reports {
//         xml.required.set(true)
//         html.required.set(true)
//     }
// }
