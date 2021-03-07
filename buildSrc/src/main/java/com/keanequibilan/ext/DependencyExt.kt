package com.keanequibilan.ext

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * https://medium.com/android-dev-hacks/kotlin-dsl-gradle-scripts-in-android-made-easy-b8e2991e2ba
 */
fun DependencyHandler.kapts(kapt: List<String>) {
    kapt.forEach { dependency -> add("kapt", dependency) }
}

fun DependencyHandler.implementModules(modules: List<String>) {
    modules.forEach { module -> add("implementation", project(module)) }
}

fun DependencyHandler.implementations(list: List<String>) {
    list.forEach { dependency -> add("implementation", dependency) }
}

fun DependencyHandler.androidTestImplementations(list: List<String>) {
    list.forEach { dependency -> add("androidTestImplementation", dependency) }
}

fun DependencyHandler.testImplementations(list: List<String>) {
    list.forEach { dependency -> add("testImplementation", dependency) }
}
