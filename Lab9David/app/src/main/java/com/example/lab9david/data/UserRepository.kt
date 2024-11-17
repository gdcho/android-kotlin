package com.example.lab9david.data

class UserRepository(private val userDao: UserDAO) {

    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }

    fun deleteEntity(user: LocalUser) {
        userDao.delete(user)
    }

    fun add(user: LocalUser) {
        userDao.add(user)
    }
}