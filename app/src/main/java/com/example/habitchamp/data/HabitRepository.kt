package com.example.habitchamp.data

import java.time.LocalDate

class HabitRepository(
    private val habitDao: HabitDao,
    private val completionDao: HabitCompletionDao
) {
    val habits = habitDao.observeHabits()
    suspend fun insertHabit(habit: Habit): Unit = habitDao.insertHabit(habit)
    suspend fun updateHabit(habit: Habit): Unit = habitDao.updateHabit(habit)
    suspend fun deleteHabit(habit: Habit): Unit = habitDao.deleteHabit(habit)

    suspend fun insertHabitCompletion(habitCompletion: HabitCompletion): Unit = completionDao.insertCompletion(habitCompletion)
    suspend fun deleteHabitCompletion(habitCompletion: HabitCompletion): Unit = completionDao.deleteCompletion(habitCompletion)
    suspend fun getHabitCompletionsCount(habitId: Long): Int = completionDao.getTotalHabitCompletions(habitId)
    suspend fun getHabitCompletionsInPeriod(habitId: Long, from: LocalDate, to: LocalDate): Int =completionDao.getHabitCompletionsInPeriod(habitId, from, to)

}