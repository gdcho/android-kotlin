package com.example.lab9david

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.lab9david.main.MainContent
import com.example.lab9david.main.SignupState
import com.example.lab9david.main.UserState

/*
    Name: David Cho
    Student#: A01351217
    Set: G
 */

class MainActivity : ComponentActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = (application as MyApp).userRepository

        setContent {
            val userState = remember { UserState(userRepository) }
            val signupState = remember { SignupState() }

            MainContent(userState = userState, signupState = signupState)
        }
    }
}
