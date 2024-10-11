package com.example.lab6davidcho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * David Cho
 * A01351217
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Shapes()
        }
    }
}

@Composable
fun Shapes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6f849d))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF1631C5))
                        .size(200.dp)
                ) {}
                Box(
                    modifier = Modifier
                        .background(Color(0xFFb30706))
                        .size(60.dp)
                ) {}
            }
            Box(
                modifier = Modifier
                    .background(Color(0xFF8153d3))
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFe08787))
                            .size(100.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF4cae51))
                            .size(80.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFefc037))
                            .size(120.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF815517))
                            .size(150.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Lab 6",
                            color = Color(0xFFFFFFFF),
                            fontSize = 40.sp,
                        )
                    }
                }
            }
        }
    }
}



