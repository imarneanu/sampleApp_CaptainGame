package com.udemy.captaingame

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CaptainViewModel : ViewModel() {
    private val _state = MutableStateFlow(CaptainState())
    val state = _state.asStateFlow()

    fun updateState(direction: String, itTreasure: Boolean) {
        _state.update {
            it.copy(
                direction = direction,
                stormOrTreasure = if (itTreasure) "Found a Treasure!" else "Storm Ahead",
                treasuresFound = if (itTreasure) it.treasuresFound + 1 else it.treasuresFound,
            )
        }
    }
}
