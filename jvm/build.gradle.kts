buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${properties["kotlin.version"]}")
    }
}

apply {
    plugin("kotlin-platform-jvm")
    from("${rootProject.rootDir.absolutePath}/publishing.gradle")
}

dependencies {
    "compile"(kotlin(module = "stdlib-jdk8", version = "${properties["kotlin.version"]}"))
    "expectedBy"(project(":common"))
}
