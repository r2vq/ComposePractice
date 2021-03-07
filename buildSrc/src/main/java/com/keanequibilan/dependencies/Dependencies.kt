package com.keanequibilan.dependencies

interface Dependencies {
    fun annotations(): List<String> = emptyList()
    fun libraries(): List<String> = emptyList()
    fun modules(): List<String> = emptyList()
    fun test(): List<String> = emptyList()
    fun androidTest(): List<String> = emptyList()
}

// modules
const val database = ":database"
const val network = ":network"
const val repository = ":repository"

// project
const val buildTools = "com.android.tools.build:gradle:${Versions.gradle}"
const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

// std lib
const val kotlinStdLib =
    "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

// android ui
const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
const val composeActivity =
    "androidx.activity:activity-compose:${Versions.composeActivity}"
const val composeMaterial =
    "androidx.compose.material:material:${Versions.compose}"
const val composeNavigation =
    "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
const val composeRuntime =
    "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
const val material = "com.google.android.material:material:${Versions.material}"
const val lifecycle =
    "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

// database
const val room = "androidx.room:room-runtime:${Versions.room}"
const val roomAnnotations = "androidx.room:room-compiler:${Versions.room}"
const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

// dependency injection
const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"

// images
const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

// network
const val moshiConverter =
    "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

// test libs
const val junit = "junit:junit:${Versions.junit}"
const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
const val espressoCore =
    "androidx.test.espresso:espresso-core:${Versions.espresso}"
