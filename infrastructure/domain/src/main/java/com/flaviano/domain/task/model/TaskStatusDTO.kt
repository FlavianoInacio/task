package com.flaviano.domain.task.model

enum class TaskStatusDTO(val id: Int) {
    TO_DO(1), IN_EXECUTION(2), PAUSED(3), FINALIZED(4);

    companion object {
        fun fromID(id: Int): TaskStatusDTO? = TaskStatusDTO.values().find { it.id == id }
    }
}
