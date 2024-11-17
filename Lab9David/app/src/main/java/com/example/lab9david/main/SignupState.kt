package com.example.lab9david.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lab9david.data.LocalUser

class SignupState {

    var uid by mutableStateOf<Int?>(null)
    var onUidChanged: (String) -> Unit = {
        val newUid = it.toIntOrNull()
        if (newUid != null) {
            uid = newUid
        }
    }

    var name by mutableStateOf("")
    var onNameChanged: (String) -> Unit = {
        if (it.isNotBlank()) {
            name = it
        }
    }

    var email by mutableStateOf("")
    var validEmail = false
    val onEmailChanged: (String) -> Unit = {
        email = it
        validEmail = email.contains("@")
    }

    fun populateFieldsWithSelectedUser(user: LocalUser) {
        uid = user.uid
        name = user.userName ?: ""
        email = user.email
    }
}
