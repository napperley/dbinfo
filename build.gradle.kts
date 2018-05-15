buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        val bintrayVer = "1.8.0"

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${properties["kotlin.version"]}")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:$bintrayVer")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

apply {
    plugin("com.jfrog.bintray")
}

allprojects {
    group = "org.digieng"
    version = "0.1"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}
