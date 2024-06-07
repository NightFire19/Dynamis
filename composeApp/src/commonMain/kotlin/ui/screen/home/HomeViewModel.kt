package ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {
    private val _count = mutableStateOf(0)
    val count: State<Int> = _count
}