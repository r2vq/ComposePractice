/**
 * https://medium.com/android-dev-hacks/kotlin-dsl-gradle-scripts-in-android-made-easy-b8e2991e2ba
 */
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(com.keanequibilan.dependencies.buildTools)
        classpath(com.keanequibilan.dependencies.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
