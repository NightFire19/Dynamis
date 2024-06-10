package ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
): ViewModel() {
    private val _count = mutableStateOf("")
    val count: State<String> = _count

    init {
        callApi()
    }

    private fun callApi() {
        viewModelScope.launch {
            repository.getIt().flowOn(Dispatchers.IO).collect{
                if (it.isSuccess) {
                    _count.value = it.getOrNull()?.title ?: "No title found..."
                }
            }
        }
    }
}