package com.example.contacts.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contacts.data.entity.Persons

@Database(entities =[Persons::class],version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun getPersonsDao(): PersonsDao

}