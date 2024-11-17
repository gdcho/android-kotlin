package com.example.lab9david.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab9david.data.LocalUser

@Composable
fun UserItem(
    user: LocalUser, onUserClicked: (LocalUser) -> Unit, onDeleteClicked: (LocalUser) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { onUserClicked(user) }, shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Text(
                    text = user.userName ?: "", style = TextStyle(
                        fontSize = 18.sp,
                    ), modifier = Modifier.padding(end = 20.dp, start = 10.dp)
                )
                Text(
                    text = user.email, style = TextStyle(
                        fontSize = 18.sp,
                    )
                )
            }
            IconButton(onClick = { onDeleteClicked(user) }) {
                Icon(
                    imageVector = Icons.Filled.Close, contentDescription = "Delete"
                )
            }
        }
    }
}

