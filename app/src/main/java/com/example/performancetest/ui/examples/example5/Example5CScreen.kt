package com.example.performancetest.ui.examples.example5

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example5CScreen(
    title: String,
    viewModel: Example5CViewModel
) {
    var count by remember { mutableStateOf(0) }

    TitleScreenColumn(title = title) {
        Text(text = "count: $count")
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }
        StableText(list = viewModel.list)
    }
}


@Composable
private fun StableText(list: SnapshotStateList<String>) {
    Text(text = "list: ${ list.toList() }")
}

class Example5CViewModel() {

    private val _list = mutableListOf("1", "2", "3")
    // Solution: snapshot state list is a stable parameter now
    val list: SnapshotStateList<String> = _list.toMutableStateList()
}
