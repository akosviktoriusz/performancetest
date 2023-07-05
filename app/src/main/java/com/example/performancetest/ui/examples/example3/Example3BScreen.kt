package com.example.performancetest.ui.examples.example3

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example3BScreen(
    title: String,
    viewModel: Example3BViewModel
) {
    TitleScreenColumn(title = title) {
        Text(text = "count: ${ viewModel.count.value }")
        Button(onClick = { viewModel.increaseCount() }) {
            Text(text = "count++")
        }
    }
}

class Example3BViewModel() : ViewModel() {
    // Solution: make parameter stable by transforming variable to Compose state
    val count = mutableStateOf(0)

    fun increaseCount() {
        count.value++
    }
}
