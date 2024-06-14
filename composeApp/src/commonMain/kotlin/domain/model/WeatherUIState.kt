package domain.model

data class WeatherUIState(
    val currentTemperature: Int,
    val currentWeatherCode: Int,
    val todayHigh: Int,
    val todayLow: Int,
)
