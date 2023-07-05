package com.example.performancetest.ui.examples.example7

import androidx.compose.runtime.Immutable

@Immutable
data class WrappedList<T>(
    val items: List<T>
)
