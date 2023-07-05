package com.example.performancetest.ui.examples.example7

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.performancetest.ui.examples.TitleScreenBox
import kotlinx.coroutines.launch

@Composable
fun Example7AScreen(
    title: String,
    viewModel: Example7AViewModel
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    TitleScreenBox(title = title) {
        LazyColumn(state = listState) {
            items(
                items = viewModel.list.items
            ) { item ->
                Text(text = item)
            }
        }

        val showButton = listState.firstVisibleItemIndex > 0

        AnimatedVisibility(visible = showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(index = 0)
                } }) {
                Text(text = "Scroll to top")
            }
        }
    }
}

class Example7AViewModel() {

    private val _list = (0..100).map {
        "Item $it"
    }

    val list = WrappedList(_list)
}