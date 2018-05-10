allprojects {
    group = "org.digieng"
    version = "0.1-SNAPSHOT"

    repositories {
        jcenter()
        mavenCentral()
    }
}

buildscript {
    val kotlinVer = "1.2.41"

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")
    }
}

apply {
    plugin("kotlin-platform-common")
}

dependencies {
    val kotlinVer = "1.2.41"

    "compile"("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVer")
}
