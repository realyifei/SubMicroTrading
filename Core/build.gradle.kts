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
    // Standard libraries from Maven Central
    implementation("log4j:log4j:1.2.16")
    implementation("junit:junit:4.8.1") // For org.junit.Assert in main code & tests
    implementation("xerces:xercesImpl:2.12.2") 
    implementation("xml-apis:xml-apis:1.4.01")
    implementation("com.sun.mail:javax.mail:1.6.2")

    // Keep jmxtools.jar as a local file dependency for now
    implementation(files("exlib/jars/jmxtools.jar"))
    
    // Ensure no other file dependencies for these libraries exist.
    // Remove any fileTree or other files() calls that might refer to the
    // JARs now handled by Maven (log4j, junit, xerces, xml-apis, javax.mail).
}

// Initial sourceSets pointing to old locations, will be updated after moving files
sourceSets {
    main {
        java {
            srcDirs("src") // "other" removed from here
        }
    }
    test {
        java {
            srcDirs("test", "other") // "other" added here
        }
    }
}

tasks.withType<Test> {
    useJUnit()
    reports {
        junitXml.required.set(true)
        html.required.set(true)
    }
}
