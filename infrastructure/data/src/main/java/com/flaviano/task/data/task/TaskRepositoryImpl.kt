package com.flaviano.task.data.task

import com.flaviano.task.data.task.datasource.TaskLocalDataSource
import com.flaviano.task.data.task.mapper.toDomain
import com.flaviano.task.data.task.mapper.toEntity
import com.flaviano.task.data.task.model.Task
import com.flaviano.task.data.task.model.TaskType

class TaskRepositoryImpl(private val taskLocalDataSource: TaskLocalDataSource) :
    TaskRepository {

    override suspend fun getAll(): Result<List<Task>> = runCatching {
        taskLocalDataSource.getAll().getOrNull()?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun insertOrUpdate(tasks: List<Task>): Result<Unit> = runCatching {
        taskLocalDataSource.insertOrUpdate(tasks = tasks.map { it.toEntity() }).getOrThrow()
    }

    override suspend fun insertOrUpdate(task: Task): Result<Unit> = runCatching {
        taskLocalDataSource.insertOrUpdate(task = task.toEntity()).getOrThrow()
    }

    override suspend fun delete(task: Task): Result<Unit> = runCatching {
        taskLocalDataSource.delete(task.toEntity()).getOrThrow()
    }

    override suspend fun getTaskById(id: Int): Result<Task> = runCatching {
        taskLocalDataSource.getById(id).getOrThrow().toDomain()
    }

    override suspend fun getTasksBy(name: String?, types: List<TaskType>): Result<List<Task>> = runCatching {
        taskLocalDataSource.getAlBy(name = name.orEmpty(), types = types).getOrThrow().map { it.toDomain() }
    }
}