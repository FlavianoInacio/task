package com.flaviano.data

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.flaviano.data.module.di.dataModule
import com.flaviano.domain.task.repository.TaskRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.inject
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

class TaskRepositoryTest : KoinTest {

    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    open val koinTestRule = KoinTestRule.create {
        allowOverride(true)
        androidContext(context)
        modules(dataModule)
    }

    @Test
    fun test_call_get_tasks() = runBlocking {
        // given
        val taskRepository by inject<TaskRepository>()
        //when
        val result = taskRepository.getTasks()
        // then
        Assert.assertTrue(result.isSuccess)

    }
}