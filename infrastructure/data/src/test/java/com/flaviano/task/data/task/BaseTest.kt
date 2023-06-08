package com.flaviano.task.data.task

import com.flaviano.task.data.di.DataModule
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

open class BaseTest : KoinTest {

    @get:Rule(order = 1)
    val koinTestRule = KoinTestRule.create {
        allowOverride(true)
        this.koin.loadModules(listOf(DataModule.modules))
    }

    @get:Rule(order = 2)
    val roomTestRule = RoomTestRule.create()


}