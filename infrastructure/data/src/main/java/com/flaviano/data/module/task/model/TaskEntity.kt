package com.flaviano.data.module.task.model

import com.flaviano.domain.task.model.TaskDTO
import com.flaviano.domain.task.model.TaskPriorityDTO
import com.flaviano.domain.task.model.TaskStatusDTO
import java.util.*

data class TaskEntity(
    val id: Int,
    val name: String,
    val finishDate: Date? = null,
    val status: Int,
    val priority: Int
)

fun TaskEntity.toDTO() = TaskDTO(
    id = id,
    name = name,
    finishDate = finishDate,
    status = TaskStatusDTO.fromID(status),
    priority = TaskPriorityDTO.fromID(priority)
)
