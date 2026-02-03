package com.example.habitchamp.ui.addHabit

import androidx.lifecycle.ViewModel
import com.example.habitchamp.data.Habit
import com.example.habitchamp.data.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddHabitViewModel @Inject constructor(
    private val repository: HabitRepository
) : ViewModel() {
    suspend fun addHabit(habit: Habit) = repository.insertHabit(habit)
}
