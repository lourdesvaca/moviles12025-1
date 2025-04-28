package com.example.practicodos.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    var name: String,
    var ingredients: String,
    var prepare: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}