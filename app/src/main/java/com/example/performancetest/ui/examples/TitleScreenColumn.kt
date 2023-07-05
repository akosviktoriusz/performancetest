package com.example.performancetest.ui.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.performancetest.ui.theme.Typography

@Composable
fun TitleScreenColumn(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column (modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = Typography.titleLarge
        )

        ContentColumn(content = content)
    }
}

@Composable
fun ContentColumn(content: @Composable ColumnScope.() -> Unit) {
    Column (content = content)
}