package com.example.performancetest.ui.examples.example3

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example3AScreen(
    title: String,
    viewModel: Example3AViewModel
) {
    TitleScreenColumn(title = title) {
        Text(text = "count: ${ viewModel.count }")
        Button(onClick = { viewModel.increaseCount() }) {
            Text(text = "count++")
        }
    }
}

class Example3AViewModel() {
    // Problem: unstable variable parameter so Compose won't be notified when its value changes
    var count = 0

    fun increaseCount() {
        count++
    }
}
