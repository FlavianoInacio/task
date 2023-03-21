package com.flaviano.task.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Upsert

interface BaseDao<T> {

    @Insert
    suspend fun insert(entity: T): Long

    @Insert
    suspend fun insert(entities: List<T>): List<Long>

    @Update
    suspend fun update(entity: T)

    @Update
    suspend fun update(entities: List<T>)

    @Delete
    suspend fun delete(entity: T)

    @Upsert
    suspend fun insertOrUpdate(entity: T)

    @Upsert
    suspend fun insertOrUpdate(entities: List<T>)

}