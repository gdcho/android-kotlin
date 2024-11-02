package com.example.lab7davidcho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * David Cho, A01351217
 */

data class StarWars(val name: String, val imageId: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val names = stringArrayResource(id = R.array.first) +
                    stringArrayResource(id = R.array.second) +
                    stringArrayResource(id = R.array.third)

            val images = listOf(
                R.drawable.ahsoka, R.drawable.bb8, R.drawable.c3po,
                R.drawable.chewbacca, R.drawable.grogu, R.drawable.jabba,
                R.drawable.kilo, R.drawable.trooper, R.drawable.yoda
            )

            var allCards by remember {
                mutableStateOf(
                    names.mapIndexed { index, name ->
                        StarWars(name, images[index])
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Button(
                    onClick = {
                        allCards = allCards.shuffled()
                    },
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text("Shuffle", fontSize = 25.sp)
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    val numberOfRows = (allCards.size + 2) / 3

                    items(numberOfRows) { rowIndex ->
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp),
                        ) {
                            val startIndex = rowIndex * 3
                            val rowCards = allCards.subList(
                                startIndex,
                                minOf(startIndex + 3, allCards.size)
                            )

                            items(rowCards.size) { index ->
                                StarWarsCard(rowCards[index])
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StarWarsCard(StarWars: StarWars) {
    var isClicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .width(if (isClicked) 300.dp else 230.dp)
            .height(if (isClicked) 320.dp else 230.dp)
            .clickable { isClicked = !isClicked },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!isClicked) {
                Text(
                    text = StarWars.name,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            Image(
                painter = painterResource(id = StarWars.imageId),
                contentDescription = StarWars.name,
                modifier = Modifier.size(if (isClicked) 400.dp else 200.dp)
            )
        }
    }
}