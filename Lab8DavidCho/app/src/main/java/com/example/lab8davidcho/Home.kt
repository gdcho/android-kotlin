package com.example.lab8davidcho

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Colour(val decimal: Long)

@Composable

fun Home(navController: NavController, starColor: (Long) -> Unit) {
    val colors = listOf (
        Colour(4294198070),
        Colour(4293467747),
        Colour(4288423856),
        Colour(4282339765),
        Colour(4280391411),
        Colour(4278228616),
        Colour(4283215696),
        Colour(4294961979),

    )
    LazyColumn {
        items(colors.size) {
            ColorItem(navController, colors[it], starColor)
        }
    }
}

@Composable
fun ColorItem(navController: NavController, color: Colour, starColor: (Long) -> Unit = {}) {
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .height(115.dp)
        .clickable { starColor(color.decimal) },
        shape = RectangleShape) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .background(color= Color(color.decimal))
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top)
        {
            IconButton(
                onClick = {
                    navController.navigate("details/${color.decimal}")
                },
            ) {
                Icon(Icons.Outlined.Info, contentDescription = "Info Button", modifier = Modifier.size(32.dp))
            }
        }
    }
}
