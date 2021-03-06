import AppDependencies.androidTestImplementations
import AppDependencies.implementModules
import AppDependencies.implementations
import AppDependencies.testImplementations

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode(AppConfig.versionCode)
        versionName(AppConfig.versionName)

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles(AppConfig.proguardConsumerRules)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // local libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementModules(AppDependencies.networkModules)

    // app libs
    implementations(AppDependencies.networkLibraries)

    // test libs
    testImplementations(AppDependencies.testLibraries)
    androidTestImplementations(AppDependencies.androidTestLibraries)
}
