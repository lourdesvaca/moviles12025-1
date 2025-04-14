package com.example.practicalista.models

import java.io.Serializable

class Person(
    val id: Int,
    val name: String,
    //val lastName: String,
    //val phone: String,
    //val email: String,
    val address: String,
    var complete: Boolean = false,
    var color: Int = 0,

): Serializable