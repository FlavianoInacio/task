package com.flaviano.task.data

import com.flaviano.task.database.entity.TaskEntity
import com.flaviano.task.domain.model.Task

fun TaskEntity.toDomain() = Task(
    id = id,
    name = name,
    taskPriority = priority,
    taskProgress = progress,
    taskStatus = status,
    term = term,
    type = type
)