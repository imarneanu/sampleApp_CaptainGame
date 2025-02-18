package com.udemy.captaingame

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.random.Random

@Composable
fun SailButton(text: String, onClick: (Boolean) -> Unit) {
    Button(onClick = { onClick(Random.nextBoolean()) })
    {
        Text("Sail $text!")
    }
}

