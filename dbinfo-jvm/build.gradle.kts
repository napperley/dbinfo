buildscript {
    val kotlinVer = "1.2.41"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")
    }
}

apply {
    plugin("kotlin-platform-jvm")
}

dependencies {
    val kotlinVer = "1.2.41"

    "compile"(kotlin(module = "stdlib-jdk8", version = kotlinVer))
    "expectedBy"(project(":"))
}