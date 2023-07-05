package com.example.performancetest.ui.examples.example4

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun Example4AScreen(
    title: String,
    viewModel: Example4AViewModel
) {
    var count by remember { mutableStateOf(0) }

    TitleScreenColumn(title = title) {
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }
        Text(text = "count: $count")

        // Problem: lambda is regenerated everytime because viewmodel is an unstable reference
        Button(onClick = { viewModel.doSomething() }) {
            Text("Button")
        }
    }
}

// Problem: unstable viewmodel even flow is private so we can't refer to it
class Example4AViewModel {
    private val flow = MutableStateFlow(0)

    fun doSomething() {}
}