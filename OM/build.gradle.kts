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
    // Add other specific JARs from Core/exlib/jars if OM needs them

    // Project dependencies (adjust if necessary)
    implementation(project(":Core"))
    implementation(project(":Generated")) // OM might use generated code

    // Test dependencies
    testImplementation(files("../Core/exlib/jars/junit-4.8.1.jar"))
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
        resources {
            srcDirs("config", "data")
            // You might need to include/exclude specific patterns if Ant did
            // e.g., includes("*.xml", "*.properties", etc.)
        }
    }
    test {
        java {
            srcDirs("test")
        }
        resources {
            // If tests also need config/data files from OM/test/resources for example
            // srcDirs("test/resources") 
        }
    }
}

tasks.withType<Test> {
    useJUnit()
    // Ensure test reports are generated, similar to Ant's junit target
    reports {
        junitXml.required.set(true)
        html.required.set(true)
    }
}
