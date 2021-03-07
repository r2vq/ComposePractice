import com.keanequibilan.appconfig.AppConfig
import com.keanequibilan.dependencies.RepositoryDependencies
import com.keanequibilan.dependencies.TestDependencies
import com.keanequibilan.ext.androidTestImplementations
import com.keanequibilan.ext.implementModules
import com.keanequibilan.ext.implementations
import com.keanequibilan.ext.kapts
import com.keanequibilan.ext.testImplementations

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    // local libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementModules(RepositoryDependencies.modules())

    // app libs
    implementations(RepositoryDependencies.libraries())
    kapts(RepositoryDependencies.annotations())

    // test libs
    testImplementations(TestDependencies.test())
    androidTestImplementations(TestDependencies.androidTest())
}
