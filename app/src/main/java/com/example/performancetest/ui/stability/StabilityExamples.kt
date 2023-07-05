package com.example.performancetest.ui.stability

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

// 1. val vs var
data class StableValue(
    val text: String
)

data class UnstableVariable(
    var text: String
)

@Stable
data class StableVariableWrapper(
    var text: String
)

data class StableWrappedVariable(
    val stableVariableWrapper: StableVariableWrapper
)

// 2. unstable collection: wrap into immutable class
data class UnstableList(
    val list: List<String>,
    val list2: SnapshotStateList<String> = list.toMutableStateList()
)

@Immutable
data class ImmutableListWrapper(
    val list: List<String>
)

data class StableWrappedList(
    val immutableListWrapper: ImmutableListWrapper
)

// 3. unstable flow: collect as state in composable method
data class UnstableFlow(
    val booleanFlow: Flow<Boolean>
)

//. 4. stable state
data class StableState(
    val state: State<Boolean>
)

// 5. stable viewmodel
class StableViewModel : ViewModel() {
    val state: State<Boolean> = mutableStateOf(false)
}
