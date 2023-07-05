package com.example.performancetest.ui.examples.example5

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example5AScreen(
    title: String,
    viewModel: Example5AViewModel
) {
    var count by remember { mutableStateOf(0) }

    TitleScreenColumn(title = title) {
        Text(text = "count: $count")
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }
        UnstableText(list = viewModel.list)
    }
}

// Problem: list is an unstable parameter
@Composable
private fun UnstableText(list: List<String>) {
    Text(text = "list: $list")
}

class Example5AViewModel() {
    private val _list = listOf("1", "2", "3")
    val list: List<String> = _list
}
