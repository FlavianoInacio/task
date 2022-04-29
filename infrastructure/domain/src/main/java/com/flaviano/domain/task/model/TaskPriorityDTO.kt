package com.flaviano.domain.task.model

enum class TaskPriorityDTO(val id: Int) {
    LOW(1), MEDIUM(2), HIGH(3);

    companion object {
        fun fromID(id: Int) = TaskPriorityDTO.values().find { it.id == id }
    }
}
