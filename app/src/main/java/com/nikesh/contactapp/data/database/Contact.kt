package com.nikesh.contactapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var phoneNumber: String,
    var email: String,
    var isActive: Boolean,
    var dateofCreation: Long,
    var image: ByteArray? = null
)
