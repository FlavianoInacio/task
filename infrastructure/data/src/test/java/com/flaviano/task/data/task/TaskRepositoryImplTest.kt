@file:OptIn(ExperimentalCoroutinesApi::class)

package com.flaviano.task.data.task

import com.flaviano.task.data.database.entity.TaskEntity
import com.flaviano.task.data.task.datasource.TaskLocalDataSource
import com.flaviano.task.data.task.model.TaskPriority
import com.flaviano.task.data.task.model.TaskStatus
import com.flaviano.task.data.task.model.TaskType
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeTrue
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Assert

import org.junit.Test
import org.koin.test.KoinTest

class TaskRepositoryImplTest : KoinTest {

    @Test
    fun `should return true when the list returned is not empty and it has success result`() = runTest {
        // given
        val taskLocalDataSource = mockk<TaskLocalDataSource>()
        val repository = TaskRepositoryImpl(taskLocalDataSource = taskLocalDataSource)
        coEvery {
            taskLocalDataSource.getAll()
        } returns Result.success(listOf(TaskEntity(name = "New task entity", status = TaskStatus.FINISHED, type = TaskType.BUY, priority = TaskPriority.AVERAGE)))
        // when
       val result =  repository.getAll()
        // then
        result.isSuccess.shouldBeTrue()
        result.getOrThrow().shouldNotBeEmpty()
    }

    @Test
    fun insertOrUpdate() {
    }

    @Test
    fun testInsertOrUpdate() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun getTaskById() {
    }

    @Test
    fun getTasksBy() {
    }
}