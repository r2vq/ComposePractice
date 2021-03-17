package com.keanequibilan.dependencies

object AppDependencies : Dependencies {
    override fun libraries(): List<String> = listOf(
        appcompat,
        composeActivity,
        composeMaterial,
        composeNavigation,
        composePaging,
        composeRuntime,
        composeUi,
        composeUiTooling,
        coreKtx,
        glide,
        koin,
        kotlinStdLib,
        lifecycle,
        material,
        stetho
    )

    override fun modules(): List<String> = listOf(
        database,
        network,
        repository
    )
}
