package com.example.performancetest.ui.examples.example2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.performancetest.ui.examples.TitleScreenColumn

@Composable
fun Example2CScreen(title: String) {

    TitleScreenColumn(title = title) {
        var count by remember { mutableStateOf(0) }

        Text(text = "count: $count")
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }

        NonRestartableColumn {
            Text(text = "Text1")
            Text(text = "Text2")
            Text(text = "Text3")

            Text(text = "count: $count")
        }
    }
}

@NonRestartableComposable
@Composable
private fun NonRestartableColumn(content: @Composable ColumnScope.() -> Unit) {
    Column(content = content)
}
