package com.flaviano.task.data.database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.flaviano.task.data.task.model.TaskPriority
import com.flaviano.task.data.task.model.TaskProgress
import com.flaviano.task.data.task.model.TaskStatus
import com.flaviano.task.data.task.model.TaskType

@ProvidedTypeConverter
class EnumTypeConverter {

    @TypeConverter
    fun fromTaskTypeToTypeId(taskType: TaskType): Int = taskType.id

    @TypeConverter
    fun fromTypeIdTtoTaskType(id: Int): TaskType = TaskType.values().first { it.id == id }

    @TypeConverter
    fun fromTaskStatusToStatusId(taskStatus: TaskStatus): Int = taskStatus.id

    @TypeConverter
    fun fromStatusIdToTaskStatus(id: Int): TaskStatus = TaskStatus.values().first { it.id == id }

    @TypeConverter
    fun fromTaskPriorityToPriorityId(taskPriority: TaskPriority): Int = taskPriority.id

    @TypeConverter
    fun fromPriorityIdToTaskPriority(id: Int): TaskPriority = TaskPriority.values().first { it.id == id }

    @TypeConverter
    fun fromTaskProgressToProgressId(taskProgress: TaskProgress?): Int? = taskProgress?.id

    @TypeConverter
    fun fromProgressIdToTaskProgress(id: Int?): TaskProgress? = TaskProgress.values().firstOrNull { it.id == id }

}