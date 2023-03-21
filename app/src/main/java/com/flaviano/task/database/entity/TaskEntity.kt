package com.flaviano.task.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flaviano.task.domain.model.TaskPriority
import com.flaviano.task.domain.model.TaskProgress
import com.flaviano.task.domain.model.TaskStatus
import com.flaviano.task.domain.model.TaskType
import java.time.Instant

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "type")
    val type: TaskType,

    @ColumnInfo(name = "status")
    val status: TaskStatus,

    @ColumnInfo(name = "progress")
    val progress: TaskProgress? = null,

    @ColumnInfo(name = "priority")
    val priority: TaskPriority,

    @ColumnInfo(name = "term")
    val term: Instant? = null,
)