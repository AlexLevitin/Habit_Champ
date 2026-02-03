package com.example.habitchamp.di

import android.content.Context
import androidx.room.Room
import com.example.habitchamp.data.AppDatabase
import com.example.habitchamp.data.HabitCompletionDao
import com.example.habitchamp.data.HabitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "habit_champ_db"
        ).build()
    }

    @Provides
    fun provideHabitDao(database: AppDatabase): HabitDao {
        return database.habitDao()
    }

    @Provides
    fun provideHabitCompletionDao(database: AppDatabase): HabitCompletionDao {
        return database.habitCompletionDao()
    }
}
