package com.example.habitchamp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

enum class Period{
    DAY,
    WEEK,
    MONTH
}

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val frequencyPerPeriod: Int = 0,
    val period: Period,
    val lastCompleted: LocalDate? = null
)