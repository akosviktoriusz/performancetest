package com.example.performancetest.ui.examples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.performancetest.ui.theme.Typography

@Composable
fun TitleScreenBox(
    title: String,
    content: @Composable BoxScope.() -> Unit
) {
    Column (modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = Typography.titleLarge
        )

        ContentBox(content = content)
    }
}

@Composable
fun ContentBox(content: @Composable BoxScope.() -> Unit) {
    Box (content = content)
}