package com.flaviano.task.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.flaviano.task.data.database.entity.TaskEntity
import com.flaviano.task.data.task.model.TaskType

@Dao
abstract class TaskDao : BaseDao<TaskEntity> {

    @Query("SELECT * FROM task")
    abstract suspend fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM task WHERE id = :id")
    abstract suspend fun getById(id: Int): TaskEntity

    @Query(
        """
            SELECT * FROM task 
            WHERE CASE :name WHEN 1 
                THEN name IN (:name) 
                ELSE 1
            END
            AND CASE :types WHEN 1
                THEN type IN (:types)
                ELSE 1
            END
        """
    )
    abstract suspend fun getAllBy(name: String, types: List<TaskType>): List<TaskEntity>

}