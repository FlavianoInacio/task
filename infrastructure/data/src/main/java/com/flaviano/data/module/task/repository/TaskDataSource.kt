package com.flaviano.data.module.task.repository

import com.flaviano.data.module.task.model.TaskEntity
import com.flaviano.data.module.task.model.toDTO
import com.flaviano.domain.task.model.TaskDTO
import logcat.logcat

class TaskDataSource {

    fun getTasks(): Result<List<TaskDTO>> = kotlin.runCatching {
        listOf<TaskEntity>()
    }.mapCatching { list ->
        list.map { it.toDTO() }
    }.onFailure {
        logcat { it.cause.toString() }
    }
}