package domain.model

data class WeatherUIState(
    val time: String = "00:00",
    val currentTemperature: String = "0",
    val currentWeatherCode: Int = 0,
    val todayHigh: Int = 0,
    val todayLow: Int = 0,
)
