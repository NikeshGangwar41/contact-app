package com.nikesh.contactapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactDataBase : RoomDatabase() {
    abstract fun getDao(): Dao
}