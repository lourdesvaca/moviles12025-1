package com.example.practicodos.db.dao

import androidx.activity.result.IntentSenderRequest
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.practicodos.db.models.Recipe

@Dao
interface RecipeDao {
    //trae la lista de las recetas
    @Query("Select * from Recipe")
    fun getAllRecipes(): ArrayList<Recipe>

    @Query("Select * from Recipe where id = :id")
    fun getRecipeById(id: Int): Recipe

    //
    @Insert
    fun insertRecipe(recipe: Recipe): Long

}