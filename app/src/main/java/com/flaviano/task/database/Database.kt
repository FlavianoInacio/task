package com.flaviano.task.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.flaviano.task.database.converter.DateConverter
import com.flaviano.task.database.converter.EnumTypeConverter
import com.flaviano.task.database.dao.TaskDao
import com.flaviano.task.database.entity.TaskEntity

@androidx.room.Database(
    version = 1,
    entities = [TaskEntity::class],
)
@TypeConverters(
    value = [DateConverter::class, EnumTypeConverter::class]
)
abstract class Database : RoomDatabase() {

    abstract val taskDao: TaskDao

    companion object {
        fun instance(context: Context): Database =
            Room.databaseBuilder(context, Database::class.java, "database.db")
                .fallbackToDestructiveMigration().build()
    }
}