package ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.Repository
import domain.model.ForecastResponse
import domain.model.WeatherUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.roundToInt

class HomeViewModel(
    private val repository: Repository
): ViewModel() {
    private val _weatherUiState = mutableStateOf(WeatherUIState())
    val weatherUIState: State<WeatherUIState> = _weatherUiState
    private var currentDateTime: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC)

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            repository.getWeather().flowOn(Dispatchers.IO).collect{ result ->
                if (result.isSuccess) {
                    mapForecastResponseToUIState(result.getOrThrow())
                }
                else if (result.isFailure) {

                }
            }
        }
    }

    private fun mapForecastResponseToUIState(forecastResponse: ForecastResponse) {
        currentDateTime = extractTimeFromISO8601(forecastResponse.current?.time)
        val dateIndex = findDateIndex(forecastResponse.daily?.time ?: emptyList(), currentDateTime)
        _weatherUiState.value =
            WeatherUIState(
                time = currentDateTime.time.toString(),
                currentTemperature = "${(forecastResponse.current?.temperature2m ?: 0.0).roundToInt()}${forecastResponse.currentUnits?.temperature2m}",
                currentWeatherCode = forecastResponse.current?.weatherCode ?: 0,
                todayHigh = "High: ${forecastResponse.daily?.temperature2mMax?.get(dateIndex)?.roundToInt() ?: 0}${forecastResponse.currentUnits?.temperature2m}",
                todayLow = "Low: ${forecastResponse.daily?.temperature2mMin?.get(dateIndex)?.roundToInt() ?: 0}${forecastResponse.currentUnits?.temperature2m}"
            )
    }

    private fun extractTimeFromISO8601(iso8601String: String?): LocalDateTime {
        iso8601String?.let {
            val instant = Instant.parse("$iso8601String:00Z")
            return instant.toLocalDateTime(TimeZone.UTC)
        } ?: run {
            return Clock.System.now().toLocalDateTime(TimeZone.UTC)
        }
    }

    private fun findDateIndex(dateList: List<String>, targetDateTime:LocalDateTime): Int {
        val targetDate = targetDateTime.date.toString()
        return dateList.indexOf(targetDate)
    }
}