package com.example.lab9david.main

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun CustomTextField(
    label: String, value: String, onValueChanged: (String) -> Unit, readOnly: Boolean = false
) {
    TextField(
        value = value, onValueChange = onValueChanged, label = { Text(label) }, readOnly = readOnly
    )
}