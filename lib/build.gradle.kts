import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
//    alias(libs.plugins.androidLibrary)
}

val libraryName = "KmpSample"

kotlin {
//    androidTarget {
//        @OptIn(ExperimentalKotlinGradlePluginApi::class)
//        compilerOptions {
//            jvmTarget.set(JvmTarget.JVM_11)
//        }
//    }

    val xcFramework = XCFramework("XC$libraryName")

    iosX64 {
        binaries.framework(libraryName) {
            xcFramework.add(this)
        }
    }

    macosX64 {
        binaries {
            sharedLib(libraryName)
            framework(libraryName)
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

//android {
//    namespace = "com.design.shared"
//    compileSdk = libs.versions.android.compileSdk.get().toInt()
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_11
//        targetCompatibility = JavaVersion.VERSION_11
//    }
//    defaultConfig {
//        minSdk = libs.versions.android.minSdk.get().toInt()
//    }
//}
