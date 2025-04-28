package com.example.practicodos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practicodos.db.dao.RecipeDao
import com.example.practicodos.db.models.Recipe

@Database(
    entities = [Recipe::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "recetario"
            ).build()
        }
    }
}