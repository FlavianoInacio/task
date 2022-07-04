package com.flaviano.data.module.di.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.flaviano.data.module.task.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    companion object {
        fun instance(context: Context) =
            Room.databaseBuilder(context, TaskDataBase::class.java, "task_database").build()
    }
}