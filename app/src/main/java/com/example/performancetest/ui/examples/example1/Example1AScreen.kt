package com.example.performancetest.ui.examples.example1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example1AScreen(title: String) {

    TitleScreenColumn(title = title) {
        // Problem: column is an inlined composable without recomposition scope
        Column {
            var count by remember { mutableStateOf(0) }

            Text(text = "count: $count")
            Button(onClick = { count++ }) {
                Text(text = "count++")
            }
        }

        Text(text = "Text1")
        Text(text = "Text2")
        Text(text = "Text3")
    }
}
