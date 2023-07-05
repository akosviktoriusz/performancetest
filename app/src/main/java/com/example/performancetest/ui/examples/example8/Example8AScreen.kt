package com.example.performancetest.ui.examples.example8

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
fun Example8AScreen(title: String) {
    TitleScreenColumn(title = title) {
        var count by remember { mutableStateOf(0) }

        Column {
            // Causes recomposition on click
            Button(onClick = { count++ }) {
                Text("Recompose")
            }

            Text("$count")
            count++ // Backwards write, writing to state after it has been read
        }
    }
}
