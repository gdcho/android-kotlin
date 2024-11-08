package com.example.lab8davidcho

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ColorInfo(code: Long) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(code)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = code.toString(16), fontSize = 50.sp)
    }
}
