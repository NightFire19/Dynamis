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
    private val _temperature = mutableStateOf(0.0)
    val temperature: State<Double> = _temperature

    init {
        callApi()
    }

    private fun callApi() {
        viewModelScope.launch {
            repository.getWeather().flowOn(Dispatchers.IO).collect{ result ->
                if (result.isSuccess) {
                    result.map { forecast ->
                        _temperature.value = forecast.current?.temperature2m?: 0.0
                    }
                }
                else if (result.isFailure) {
                    _temperature.value = 404.0
                }
            }
        }
    }



}