plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral() // For potential future Maven dependencies
}

dependencies {
    implementation(files("exlib/jars/jmxtools.jar"))
    implementation(files("exlib/jars/log4j-1.2.16.jar"))
    implementation(files("exlib/jars/javax.mail.jar"))
    implementation(files("exlib/jars/xercesImpl.jar")) // From exlib/jars/LIST
    implementation(files("exlib/jars/xml-apis.jar"))   // From exlib/jars/LIST

    testImplementation(files("exlib/jars/junit-4.8.1.jar"))
}

// Initial sourceSets pointing to old locations, will be updated after moving files
sourceSets {
    main {
        java {
            srcDirs("src", "other")
        }
    }
    test {
        java {
            srcDirs("test")
        }
    }
}
