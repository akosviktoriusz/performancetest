package com.example.performancetest.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.performancetest.ui.theme.Typography

@Composable
fun MenuList(
    title: String,
    items: List<MenuScreen>,
    onItemClick: (MenuScreen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
    ) {
        Text(
            text = title,
            style = Typography.titleLarge
        )

        val itemList by remember { mutableStateOf(items) }

        LazyColumn {
            items(itemList) { item ->
                MenuListItem(text = item.title) {
                    onItemClick.invoke(item)
                }
            }
        }
    }
}