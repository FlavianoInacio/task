package com.flaviano.data.module.task.repository

import com.flaviano.domain.task.model.TaskDTO
import com.flaviano.domain.task.repository.TaskRepository

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource) : TaskRepository {
    override fun getTasks(): Result<List<TaskDTO>> = taskDataSource.getTasks()
}