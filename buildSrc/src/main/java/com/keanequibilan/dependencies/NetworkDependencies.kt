package com.keanequibilan.dependencies

object NetworkDependencies : Dependencies {
    override fun libraries() = listOf(
        appcompat,
        coreKtx,
        koin,
        kotlinStdLib,
        moshi,
        moshiConverter,
        retrofit
    )

    override fun annotations(): List<String> = listOf(
        moshiCodeGen
    )
}
