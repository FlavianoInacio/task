package com.flaviano.task.data.task.mapper

import com.flaviano.task.data.database.entity.TaskEntity
import com.flaviano.task.domain.task.model.Task

fun Task.toEntity() = TaskEntity(
    id = id?: 0,
    name = name,
    priority = taskPriority,
    progress = taskProgress,
    status = taskStatus,
    term = term,
    type = type
)