package com.example.lab9david.main

import androidx.compose.runtime.toMutableStateList
import com.example.lab9david.data.LocalUser
import com.example.lab9david.data.UserRepository

class UserState(private val repository: UserRepository) {

    val users = repository.getAll().toMutableStateList()

    fun add(localUser: LocalUser) {
        repository.add(localUser)
    }

    fun refresh() {
        users.apply {
            clear()
            addAll(repository.getAll())
        }
    }

    fun delete(localUser: LocalUser) {
        users.remove(localUser)
        repository.deleteEntity(localUser)
    }

}