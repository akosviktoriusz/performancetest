package com.example.performancetest.ui.examples.example6

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example6AScreen(
    title: String,
    viewModel: Example6AViewModel
) {

    TitleScreenColumn(title = title) {
        Button(onClick = { viewModel.add() }) {
            Text(text = "Add")
        }
        NoteList(notes = viewModel.list)
    }
}

@Composable
private fun NoteList(notes: List<Note>) {

    LazyColumn {
        items(
            items = notes
        ) { note ->
            NoteRow(note)
        }
    }
}

@Composable
private fun NoteRow(note: Note) {
    Text(text = note.title)
}

class Example6AViewModel() {
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
