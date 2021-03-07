import com.keanequibilan.appconfig.AppConfig
import com.keanequibilan.dependencies.AppDependencies
import com.keanequibilan.dependencies.TestDependencies
import com.keanequibilan.ext.androidTestImplementations
import com.keanequibilan.ext.implementModules
import com.keanequibilan.ext.implementations
import com.keanequibilan.ext.kapts
import com.keanequibilan.ext.testImplementations

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.keanequibilan.puppapp"
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode(AppConfig.versionCode)
        versionName(AppConfig.versionName)

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
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
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
        kotlinCompilerVersion = "1.4.30"
    }
}

dependencies {
    // local libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementModules(AppDependencies.modules())

    // app libs
    implementations(AppDependencies.libraries())
    kapts(AppDependencies.annotations())

    // test libs
    testImplementations(TestDependencies.test())
    androidTestImplementations(TestDependencies.androidTest())
}
