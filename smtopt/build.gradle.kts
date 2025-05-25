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
    // Assuming similar base dependencies as Core for now, can be refined
    implementation(files("../Core/exlib/jars/jmxtools.jar"))
    implementation(files("../Core/exlib/jars/log4j-1.2.16.jar"))
    // implementation(files("../Core/exlib/jars/javax.mail.jar")) // Uncertain if needed
    // implementation(files("../Core/exlib/jars/xercesImpl.jar"))   // Uncertain if needed
    // implementation(files("../Core/exlib/jars/xml-apis.jar"))    // Uncertain if needed

    // Project dependencies (Uncertain, but Core is a common one)
    implementation(project(":Core")) 

    // Test dependencies - Add if smtopt has its own tests
    // testImplementation(files("../Core/exlib/jars/junit-4.8.1.jar"))
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
        // resources { // Add if smtopt has resource files to package
        //     srcDirs("resources") 
        // }
    }
    // test { // Add if smtopt has a 'test' directory
    //     java {
    //         srcDirs("test")
    //     }
    // }
}

// If smtopt produces a JAR that needs to be consumable by other projects or runnable
// tasks.jar {
//     // manifest {
//     //     attributes("Main-Class": "com.rr.smtopt.MainClass") // Example
//     // }
// }
