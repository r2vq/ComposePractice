package com.keanequibilan.dependencies

object RepositoryDependencies : Dependencies {
    override fun libraries() = listOf(
        appcompat,
        coreKtx,
        koin,
        kotlinStdLib
    )

    override fun modules() = listOf(
        network
    )

}
