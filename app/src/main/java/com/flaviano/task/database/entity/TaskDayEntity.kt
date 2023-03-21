package com.flaviano.task.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "task_day", foreignKeys = [
        ForeignKey(
            entity = TaskDayEntity::class,
            parentColumns = ["id"],
            childColumns = ["task_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
            deferred = true
        ),
        ForeignKey(
            entity = DayEntity::class,
            parentColumns = ["id"],
            childColumns = ["day_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            deferred = true
        )
    ]
)
data class TaskDayEntity(
    @ColumnInfo(name = "task_id")
    val taskId: Int,

    @ColumnInfo(name = "day_id")
    val dayId: Int,

    @ColumnInfo(name = "status")
    val status: Int,

    @ColumnInfo(name = "progress")
    val progress: Int

)
