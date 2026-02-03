package com.example.habitchamp.ui.habitList

import androidx.lifecycle.ViewModel
import com.example.habitchamp.data.Habit
import com.example.habitchamp.data.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HabitListViewModel @Inject constructor(
    private val repository: HabitRepository
) : ViewModel() {
    val habits: Flow<List<Habit>> = repository.habits
    // need to create a ui specific model (look chat with gpt), becuase now habit doesnt contain enough info (if was completed today or not etc)
}