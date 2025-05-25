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
    // Assuming similar base dependencies as Core for now
    implementation(files("../Core/exlib/jars/jmxtools.jar"))
    implementation(files("../Core/exlib/jars/log4j-1.2.16.jar"))
    implementation(files("../Core/exlib/jars/javax.mail.jar"))
    implementation(files("../Core/exlib/jars/xercesImpl.jar"))
    implementation(files("../Core/exlib/jars/xml-apis.jar"))

    // It's likely that Generated code depends on Core
    implementation(project(":Core")) 

    // Test dependencies - add if Generated has its own tests
    // testImplementation(files("../Core/exlib/jars/junit-4.8.1.jar"))
}

sourceSets {
    main {
        java {
            srcDirs(
                "src",
                "model/internal/version/1.0.0/src",
                "model/fix/version/1.0.0/src",
                "model/codec-client/version/1.0.0/src",
                "model/codec-exchange/version/1.0.0/src",
                "model/codec-base/version/1.0.0/src",
                "model/codec-binary/version/1.0.0/src",
                "model/binary/version/1.0.0/src",
                "model/codec-factory/version/1.0.0/src"
            )
        }
    }
    // Assuming no specific tests for 'Generated' module for now,
    // as Ant script didn't show separate test compilation for it,
    // but rather compiled all test classes together.
    // test {
    //     java {
    //         srcDirs("test") // if a 'Generated/test' directory exists
    //     }
    // }
}
