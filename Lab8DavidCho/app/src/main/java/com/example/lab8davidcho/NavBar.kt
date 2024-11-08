package com.example.lab8davidcho

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(navController: NavController, starState: Long) {
    CenterAlignedTopAppBar(
        title = { Text("Colors", fontSize = 40.sp) },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate("home")
                }
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        actions = {
            Icon(
                Icons.Default.Star,
                contentDescription = "Star Icon",
                tint = Color(starState),
                modifier = Modifier.size(50.dp)

            )
        }
    )
}