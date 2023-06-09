package com.flaviano.task.data.task.mapper

import com.flaviano.task.data.database.entity.TaskEntity
import com.flaviano.task.domain.task.model.Task

fun TaskEntity.toDomain() = Task(
    id = id,
    name = name,
    taskPriority = priority,
    taskProgress = progress,
    taskStatus = status,
    term = term,
    type = type
)