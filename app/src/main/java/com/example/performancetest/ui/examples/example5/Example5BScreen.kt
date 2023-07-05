package com.example.performancetest.ui.examples.example5

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun Example5BScreen(
    title: String,
    viewModel: Example5BViewModel
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

// Solution: immutable list is a stable parameter now
@Composable
private fun StableText(list: ImmutableList<String>) {
    Text(text = "list: $list")
}

/*
@Immutable
data class ImmutableListWrapper(
    val list: List<String>
)
 */

class Example5BViewModel() {

    private val _list = listOf("1", "2", "3")
    // list is immutable now, no need wrap and annotate it as immutable
    val list = _list.toImmutableList()
}
