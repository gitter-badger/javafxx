import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin
import org.jetbrains.dokka.gradle.DokkaTask
import org.gradle.language.base.plugins.LifecycleBasePlugin.*

group = ARTIFACT_STYLES.asGroup()
version = RELEASE_VERSION

plugins {
    `java-library`
    kotlin("jvm")
    dokka
    `bintray-release`
}

java.sourceSets {
    "main" { java.srcDir("src") }
    "test" {
        resources.srcDir("tests/res")
        java.srcDir("tests/src")
    }
}

val ktlint by configurations.creating

dependencies {
    compile(project(":$ARTIFACT_COMMONS"))
    compile(kotlin("stdlib", VERSION_KOTLIN))

    testImplementation(kotlin("test", VERSION_KOTLIN))
    testImplementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(testFX("core"))
    testImplementation(testFX("junit"))

    ktlint(ktlint())
}

tasks {
    "ktlint"(JavaExec::class) {
        get("check").dependsOn(ktlint)
        group = VERIFICATION_GROUP
        inputs.dir("src")
        outputs.dir("src")
        description = "Check Kotlin code style."
        classpath = ktlint
        main = "com.github.shyiko.ktlint.Main"
        args("src/**/*.kt")
    }
    "ktlintFormat"(JavaExec::class) {
        group = "formatting"
        inputs.dir("src")
        outputs.dir("src")
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        main = "com.github.shyiko.ktlint.Main"
        args("-F", "src/**/*.kt")
    }

    withType<DokkaTask> {
        outputDirectory = "$buildDir/docs"
        doFirst { file(outputDirectory).deleteRecursively() }
    }
}

publish {
    repoName = RELEASE_ARTIFACT
    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = ARTIFACT_STYLES
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}