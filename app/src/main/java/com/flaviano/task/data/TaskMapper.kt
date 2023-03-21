package com.flaviano.task.data

import com.flaviano.task.database.entity.TaskEntity
import com.flaviano.task.domain.model.Task

fun Task.toEntity() = TaskEntity(
    id = id?: 0,
    name = name,
    priority = taskPriority,
    progress = taskProgress,
    status = taskStatus,
    term = term,
    type = type
)