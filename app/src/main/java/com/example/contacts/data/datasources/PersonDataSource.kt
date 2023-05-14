package com.example.contacts.data.datasources

import android.annotation.SuppressLint
import com.example.contacts.data.entity.Persons
import com.example.contacts.room.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PersonDataSource(var pdao: PersonsDao) {
    suspend  fun save(name: String,phone:String){
        val newPerson = Persons(0,name,phone)
        pdao.save(newPerson)
    }

    suspend fun update(id:Int, name: String,phone:String){
        val updatePerson = Persons(id,name,phone)
        pdao.update(updatePerson)
    }

    @SuppressLint("SuspiciousIndentation")
    suspend  fun delete(id:Int){
        val deletePerson = Persons(id,"","")
        pdao.delete(deletePerson)
    }

    suspend fun loadPersons(): List<Persons> =
        withContext(Dispatchers.IO){
            pdao.loadPersons()
        }


    suspend fun search(searchText:String): List<Persons> =
        withContext(Dispatchers.IO){
            pdao.search(searchText)
        }
}