package com.flaviano.task.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.flaviano.task.domain.TaskRepository
import com.flaviano.task.domain.model.Task
import com.flaviano.task.domain.model.TaskPriority
import com.flaviano.task.domain.model.TaskStatus
import com.flaviano.task.domain.model.TaskType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeTrue
import org.amshove.kluent.shouldNotBeEmpty
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.inject

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class TaskRepositoryImplTest : BaseTest() {

    @Test
    fun `should return true when the list returned is not empty and it has the same quantity of inserted`() = runTest {

        //given
        val taskRepository by inject<TaskRepository>()
        val task = Task(name = "test", type = TaskType.BUY, taskStatus = TaskStatus.ON_HOLD, taskPriority = TaskPriority.LOW)
        val list = listOf(task, task, task)

        // when
        taskRepository.insertOrUpdate(list).getOrThrow()
        val test = taskRepository.getAll()

        // then
        test.isSuccess.shouldBeTrue()
        test.getOrThrow().shouldNotBeEmpty()
        test.getOrThrow().size shouldBeEqualTo list.size

    }

}