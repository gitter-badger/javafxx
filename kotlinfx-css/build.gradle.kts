import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin
import org.jetbrains.dokka.gradle.DokkaTask
import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = "$releaseArtifact.css"
version = releaseVersion

plugins {
    `java-library`
    kotlin("jvm")
}

java.sourceSets {
    "main" { java.srcDir("src") }
    "test" { java.srcDir("tests/src") }
}

val ktlint by configurations.creating

dependencies {
    compile(project(":kotlinfx-core"))
    compile(kotlin("stdlib", kotlinVersion))
    ktlint(ktlint())
    testCompile(kotlin("test", kotlinVersion))
    testCompile(testFX("core"))
    testCompile(testFX("junit"))
}

tasks {
    "ktlint"(JavaExec::class) {
        get("check").dependsOn(ktlint)
        group = "verification"
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
}