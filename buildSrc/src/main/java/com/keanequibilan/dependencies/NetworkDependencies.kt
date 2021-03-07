package com.keanequibilan.dependencies

object NetworkDependencies : Dependencies {
    override fun libraries() = listOf(
        appcompat,
        coreKtx,
        koin,
        kotlinStdLib,
        moshiConverter,
        retrofit
    )
}
