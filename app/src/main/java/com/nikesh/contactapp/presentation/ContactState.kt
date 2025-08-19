package com.nikesh.contactapp.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.nikesh.contactapp.data.database.Contact

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val id: MutableState<Int> = mutableStateOf(1),
    val name: MutableState<String> = mutableStateOf(""),
    val phone: MutableState<String> = mutableStateOf(""),
    val email: MutableState<String> = mutableStateOf(""),
    val dateOfCreation: MutableState<Long> = mutableStateOf(System.currentTimeMillis()),
    val image: MutableState<ByteArray?> = mutableStateOf(null)
)
