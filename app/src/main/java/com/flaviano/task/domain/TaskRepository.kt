package com.flaviano.task.domain

import com.flaviano.task.domain.model.Task
import com.flaviano.task.domain.model.TaskType

interface TaskRepository {

    suspend fun getAll(): Result<List<Task>>

    suspend fun insertOrUpdate(tasks: List<Task>): Result<Unit>

    suspend fun insertOrUpdate(task: Task): Result<Unit>

    suspend fun delete(task: Task): Result<Unit>

    suspend fun getTaskById(id: Int): Result<Task>

    suspend fun getTasksBy(name: String? = null,types : List<TaskType> = emptyList()): Result<List<Task>>
}