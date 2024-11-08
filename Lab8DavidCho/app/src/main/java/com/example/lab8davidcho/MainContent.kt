package com.example.lab8davidcho

import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.ui.Modifier

@Composable
fun MainContent() {

    val navController = rememberNavController()
    var starState by remember { mutableLongStateOf(16777215) }
    val changeStarColor: (Long) -> Unit = { newColor ->
        starState = newColor
    }

    Scaffold(
        topBar = {
            NavBar(navController, starState)
        },
    ) {
        padding ->
        NavHost(
            navController= navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home"){
                Home(navController, changeStarColor)
            }
            composable(
                "details/{color}",
                arguments = listOf(navArgument("color") {
                    type = NavType.LongType
                })
            ) {
                val color = it.arguments?.getLong("color") ?: 0L
                ColorInfo(color)
            }
        }
    }

}