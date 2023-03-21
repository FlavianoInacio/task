package com.flaviano.task.data

import com.flaviano.task.di.ModuleDI
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

open class BaseTest : KoinTest {

    @get:Rule(order = 1)
    val koinTestRule = KoinTestRule.create {
        allowOverride(true)
        this.koin.loadModules(listOf(ModuleDI.modules))
    }

    @get:Rule(order = 2)
    val roomTestRule = RoomTestRule.create()


}