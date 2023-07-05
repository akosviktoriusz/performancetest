package com.example.performancetest.ui.examples.example1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example1BScreen(title: String) {

    TitleScreenColumn(title = title) {
        Column {
            // Solution: wrap column into scoped composable
            WrappedColumn {
                var count by remember { mutableStateOf(0) }

                Text(text = "count: $count")
                Button(onClick = { count++ }) {
                    Text(text = "count++")
                }
            }

            Text(text = "Text1")
            Text(text = "Text2")
            Text(text = "Text3")
        }
    }
}

@Composable
fun WrappedColumn(content: @Composable ColumnScope.() -> Unit) {
    Column(content = content)
}