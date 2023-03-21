package com.flaviano.task.domain.model

import java.time.Instant

data class Task(
    val id: Int? = null,
    val name: String,
    val type: TaskType,
    val taskPriority: TaskPriority,
    val taskProgress: TaskProgress? = null,
    val taskStatus: TaskStatus = TaskStatus.ON_HOLD,
    val term : Instant? = null,
)
