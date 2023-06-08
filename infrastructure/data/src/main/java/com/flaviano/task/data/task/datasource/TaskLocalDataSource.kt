package com.flaviano.task.data.task.datasource

import com.flaviano.task.data.database.dao.TaskDao
import com.flaviano.task.data.database.entity.TaskEntity
import com.flaviano.task.data.task.model.TaskType

class TaskLocalDataSource(private val taskDao: TaskDao) {

    suspend fun insertOrUpdate(tasks: List<TaskEntity>) = runCatching {
        taskDao.insertOrUpdate(tasks)
    }

    suspend fun insertOrUpdate(task: TaskEntity) = runCatching {
        taskDao.insertOrUpdate(task)
    }

    suspend fun getAll(): Result<List<TaskEntity>> = runCatching {
        taskDao.getAll()
    }

    suspend fun delete(task: TaskEntity) : Result<Unit> = runCatching {
        taskDao.delete(task)
    }

    suspend fun getById(id : Int) : Result<TaskEntity> = runCatching {
        taskDao.getById(id)
    }

    suspend fun getAlBy(name : String, types : List<TaskType>): Result<List<TaskEntity>> = runCatching {
        taskDao.getAllBy(name = name, types = types)
    }

}