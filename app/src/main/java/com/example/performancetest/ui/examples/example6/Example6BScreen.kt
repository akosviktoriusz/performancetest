package com.example.performancetest.ui.examples.example6

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import com.example.performancetest.ui.examples.TitleScreenColumn
import kotlinx.coroutines.launch

@Composable
fun Example6BScreen(
    title: String,
    viewModel: Example6BViewModel
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    TitleScreenColumn(title = title) {
        Button(onClick = {
            viewModel.add()
            coroutineScope.launch {
                listState.animateScrollToItem(index = 0)
            }
        }) {
            Text(text = "Add")
        }
        NoteList(
            notes = viewModel.list,
            listState = listState
        )
    }
}

@Composable
private fun NoteList(
    notes: List<Note>,
    listState: LazyListState
) {

    LazyColumn(state = listState) {
        items(
            items = notes,
            key = { note -> note.id}
        ) { note ->
            NoteRow(note)
        }
    }
}

@Composable
private fun NoteRow(note: Note) {
    Text(text = note.title)
}

class Example6BViewModel() {
    private var id = 100

    private val initialList = (id downTo 1).map {
        Note(
            id = it,
            title = "Item $it"
        )
    }

    val list = mutableStateListOf<Note>()

    init {
        list.addAll(initialList)
    }

    fun add() {
        list.add(0, Note(++id, "Item $id"))
    }
}
