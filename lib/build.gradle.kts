import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

val libraryName = "KmpSample"

kotlin {

    val xcFramework = XCFramework("XC$libraryName")

    iosX64 {
        binaries.framework(libraryName) {
            xcFramework.add(this)
        }
        compilations.configureEach {
            compilerOptions.configure {
                freeCompilerArgs.add("-Xruntime-logs=gc=info")
            }
        }
    }

    macosX64 {
        binaries {
            sharedLib(libraryName)
            framework(libraryName)
            compilations.configureEach {
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xruntime-logs=gc=info")
                }
            }
        }
    }

    sourceSets.all {
        languageSettings.apply {
            optIn("kotlin.ExperimentalUnsignedTypes")
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.RequiresOptIn")
                optIn("kotlin.js.ExperimentalJsExport")
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
                optIn("kotlin.ExperimentalUnsignedTypes")
                optIn("kotlin.ExperimentalStdlibApi")
                optIn("kotlin.native.ExperimentalNativeApi")
            }
        }

        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlinx.coroutines.test)
            }
        }
    }
}
