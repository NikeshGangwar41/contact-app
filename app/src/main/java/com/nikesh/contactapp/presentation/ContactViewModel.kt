package com.nikesh.contactapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikesh.contactapp.data.database.Contact
import com.nikesh.contactapp.data.database.ContactDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class ContactViewModel @Inject constructor(var dataBase: ContactDataBase) : ViewModel() {
    private var isSortedByName = MutableStateFlow(true)
    private var contact = isSortedByName.flatMapLatest {
        if (it) {
            dataBase.getDao().getContactsOrderedByName()
        } else {
            dataBase.getDao().getContactsOrderedByDate()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val _state = MutableStateFlow(ContactState())
    val state = combine(_state, isSortedByName, contact) { state, isSortedByName, contact ->
        state.copy(
            contacts = contact,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun saveContact() {
        val contact = Contact(
            id = state.value.id.value,
            name = _state.value.name.value,
            phoneNumber = _state.value.phone.value,
            email = _state.value.email.value,
            dateofCreation = System.currentTimeMillis().toLong(),
            isActive = true,
            image = state.value.image.value
        )

    }

}