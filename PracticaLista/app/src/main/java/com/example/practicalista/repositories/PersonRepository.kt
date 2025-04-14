package com.example.practicalista.repositories

import com.example.practicalista.models.Person

object PersonRepository {
    private val people = arrayListOf(
        Person(1, "Tarea1", "Descripcion de la tarea 1", false, 1),
        Person(2, "Tarea2", "Descripcion de la tarea 2", true, 2),
        Person(3, "Tarea3", "Descripcion de la tarea 3", false, 3),
        Person(4, "Tarea4", "Descripcion de la tarea 4", true, 4),
        Person(5, "Tarea5", "Descripcion de la tarea 5", false, 5),
        Person(6, "Tarea6", "Descripcion de la tarea 6", false, 6),
        Person(7, "Tarea7", "Descripcion de la tarea 7", false, 7),
        Person(8, "Tarea8", "Descripcion de la tarea 8", false, 8),
        Person(9, "Tarea9", "Descripcion de la tarea 9", false, 9),
        Person(10, "Tarea10", "Descripcion de la tarea 10", false, 10),
        Person(11, "Tarea11", "Descripcion de la tarea 11", false, 11),
        Person(12, "Tarea12", "Descripcion de la tarea 12", false, 12),
        Person(13, "Tarea13", "Descripcion de la tarea 13", false, 13),
        Person(14, "Tarea14", "Descripcion de la tarea 14", false, 14),
        Person(15, "Tarea15", "Descripcion de la tarea 15", false, 15),
    )

    fun getPeople(): ArrayList<Person> {
        return people.clone() as ArrayList<Person>
    }

    fun savePerson(person: Person) {
        val index = people.indexOfFirst { it.id == person.id }
        people[index] = person
    }

    fun deletePerson(person: Person?){
        people.remove(person)
    }
}