package com.flaviano.task.database.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.time.Instant
import java.util.Date

@ProvidedTypeConverter
class DateConverter {

    @TypeConverter
    fun fromDateToTimestamp(date: Date): Long = date.time

    @TypeConverter
    fun fromTimestampToDate(timestamp: Long): Date = Date(timestamp)

    @TypeConverter
    fun fromInstantToTimestamp(instant: Instant?): Long? = instant?.toEpochMilli()

    @TypeConverter
    fun fromTimestampToInstant(timestamp: Long?): Instant? = timestamp?.let {
        Instant.ofEpochMilli(
            it
        )
    }
}