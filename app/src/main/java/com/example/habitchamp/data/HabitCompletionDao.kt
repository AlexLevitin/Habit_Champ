package com.example.habitchamp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface HabitCompletionDao {
    @Query("SELECT * FROM habits_completion WHERE habitId = :habitId") // the ":" means habitId is a parameter
    fun observeAllCompletions(habitId: Long): Flow<List<HabitCompletion>>
    @Query("SELECT COUNT(*) FROM habits_completion WHERE habitId = :habitId")
    suspend fun getTotalHabitCompletions(habitId: Long): Int
    @Query("""
        SELECT COUNT(*) 
        FROM habits_completion
        WHERE habitId = :habitId
        AND completionDate BETWEEN :from AND :to
    """)
    suspend fun getHabitCompletionsInPeriod(
        habitId: Long,
        from: LocalDate,
        to: LocalDate
    ): Int

    @Insert
    suspend fun insertCompletion(completion: HabitCompletion)
    @Delete
    suspend fun deleteCompletion(completion: HabitCompletion)
}