package com.keanequibilan.dependencies

object DatabaseDependencies : Dependencies {
    override fun annotations() = listOf(
        roomAnnotations
    )

    override fun libraries(): List<String> = listOf(
        appcompat,
        coreKtx,
        koin,
        kotlinStdLib,
        room,
        roomKtx
    )
}
