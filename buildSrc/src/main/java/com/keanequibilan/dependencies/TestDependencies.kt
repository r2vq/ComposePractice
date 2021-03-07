package com.keanequibilan.dependencies

object TestDependencies : Dependencies {
    override fun test() = listOf(
        junit
    )

    override fun androidTest() = listOf(
        extJunit,
        espressoCore
    )

}
