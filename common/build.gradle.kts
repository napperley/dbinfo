import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayPlugin
import com.jfrog.bintray.gradle.BintrayUploadTask
import groovy.util.Node
import org.gradle.api.publish.maven.internal.publisher.MavenPublisher
import org.gradle.jvm.tasks.Jar

buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${properties["kotlin.version"]}")
    }
}

apply {
    plugin("kotlin-platform-common")
    from("${rootProject.rootDir.absolutePath}/publishing.gradle")
}

dependencies {
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-common:${properties["kotlin.version"]}")
}
