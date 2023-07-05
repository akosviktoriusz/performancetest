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
fun Example4BScreen(
    title: String,
    viewModel: Example4BViewModel
) {

    var count by remember { mutableStateOf(0) }

    // Solution: remember lambda
    val rememberedLambda = remember { { viewModel.doSomething() } }

    TitleScreenColumn(title = title) {
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }
        Text(text = "count: $count")

        Button(onClick = rememberedLambda) {
            Text("Button")
        }
    }
}

class Example4BViewModel {
    private val flow = MutableStateFlow(0)

    fun doSomething() {}
}
