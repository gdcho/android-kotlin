package com.example.lab9david

import android.app.Application
import androidx.room.Room
import com.example.lab9david.data.AppDataBase
import com.example.lab9david.data.UserRepository

class MyApp : Application() {

    private val db by lazy {

        Room.databaseBuilder(
            applicationContext, AppDataBase::class.java, "my-database"
        ).allowMainThreadQueries().build()
    }

    val userRepository by lazy {
        UserRepository(db.userDao())
    }
}