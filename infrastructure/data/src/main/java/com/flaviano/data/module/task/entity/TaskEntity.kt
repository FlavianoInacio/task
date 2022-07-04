package com.flaviano.data.module.task.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flaviano.domain.task.model.TaskStatusDTO
import java.util.*

@Entity
class TaskEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "finishDate")
    var finishDate: Date? = null

    @ColumnInfo(name = "status")
    var status: Int = TaskStatusDTO.TO_DO.id

    @ColumnInfo(name = "priority")
    var priority: Int = TaskStatusDTO.TO_DO.id
}