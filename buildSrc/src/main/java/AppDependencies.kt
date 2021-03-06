import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * https://medium.com/android-dev-hacks/kotlin-dsl-gradle-scripts-in-android-made-easy-b8e2991e2ba
 */
object AppDependencies {
    // std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val composeActivity =
        "androidx.activity:activity-compose:${Versions.composeActivity}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    private const val composeRuntime =
        "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    private const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // dependency injection
    private const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // images
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // network
    private const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    // test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = listOf(
        appcompat,
        composeActivity,
        composeMaterial,
        composeNavigation,
        composeRuntime,
        composeUi,
        composeUiTooling,
        coreKtx,
        glide,
        koin,
        kotlinStdLib,
        lifecycle,
        material,
        moshiConverter,
        retrofit
    )

    val androidTestLibraries = listOf(
        extJunit,
        espressoCore
    )

    val testLibraries = listOf(
        junit
    )

    @Suppress("unused")
    fun DependencyHandler.kapts(kapt: List<String>) {
        kapt.forEach { dependency -> add("kapt", dependency) }
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
}
