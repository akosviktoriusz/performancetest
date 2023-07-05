package com.example.performancetest.ui.examples.example2

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example2AScreen(title: String) {

    TitleScreenColumn(title = title) {
        var count by remember { mutableStateOf(0) }

        Text(text = "count: $count")
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }

        // Problem: these composables will be skipped
        // but their parameters will also be checked at recomposition
        Text(text = "Text1")
        Text(text = "Text2")
        Text(text = "Text3")
    }
}
