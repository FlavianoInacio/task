package com.flaviano.domain.task.model

import java.util.*

data class TaskDTO(
    val id: Int,
    val name: String,
    val finishDate: Date? = null,
    val status: TaskStatusDTO?,
    val priority: TaskPriorityDTO?
)
