package com.flaviano.domain.task.repository

import com.flaviano.domain.task.model.TaskDTO

interface TaskRepository {

    /**
     * Attempt get tasks list that have been added
     */
    fun getTasks(): Result<List<TaskDTO>>
}