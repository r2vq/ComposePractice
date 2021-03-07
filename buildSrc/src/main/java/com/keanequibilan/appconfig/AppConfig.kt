package com.keanequibilan.appconfig

import com.keanequibilan.dependencies.Versions

/**
 * https://medium.com/android-dev-hacks/kotlin-dsl-gradle-scripts-in-android-made-easy-b8e2991e2ba
 */
object AppConfig {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.3"
    const val jvmTarget = "1.8"

    const val composeCompiler = Versions.compose
    const val kotlinCompiler = Versions.kotlin

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules = "consumer-rules.pro"
}
