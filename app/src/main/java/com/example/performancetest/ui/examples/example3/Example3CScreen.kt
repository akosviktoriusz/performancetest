package com.example.performancetest.ui.examples.example3

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example3CScreen(
    title: String,
    viewModel: Example3CViewModel
) {
    TitleScreenColumn(title = title) {
        Text(text = "unstableCount: ${ viewModel.unstableCount }")
        Button(onClick = { viewModel.increaseUnstableCount() }) {
            Text(text = "unstableCount++")
        }

        Text(text = "stableCount: ${ viewModel.stableCount.value }")
        Button(onClick = { viewModel.increaseStableCount() }) {
            Text(text = "stableCount++")
        }
    }
}

class Example3CViewModel() {
    var unstableCount = 0
    val stableCount = mutableStateOf(0)

    fun increaseUnstableCount() {
        unstableCount++
    }

    fun increaseStableCount() {
        stableCount.value++
    }
}
