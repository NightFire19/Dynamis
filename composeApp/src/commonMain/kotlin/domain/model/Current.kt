package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("time"                 ) var time                : String? = null,
    @SerialName("interval"             ) var interval            : Int?    = null,
    @SerialName("temperature_2m"       ) var temperature2m       : Double? = null,
    @SerialName("relative_humidity_2m" ) var relativeHumidity2m  : Int?    = null,
    @SerialName("apparent_temperature" ) var apparentTemperature : Double? = null,
    @SerialName("is_day"               ) var isDay               : Int?    = null,
    @SerialName("precipitation"        ) var precipitation       : Int?    = null,
    @SerialName("rain"                 ) var rain                : Int?    = null,
    @SerialName("showers"              ) var showers             : Int?    = null,
    @SerialName("snowfall"             ) var snowfall            : Int?    = null,
    @SerialName("weather_code"         ) var weatherCode         : Int?    = null,
    @SerialName("cloud_cover"          ) var cloudCover          : Int?    = null,
    @SerialName("surface_pressure"     ) var surfacePressure     : Double? = null,
    @SerialName("wind_speed_10m"       ) var windSpeed10m        : Int?    = null,
    @SerialName("wind_direction_10m"   ) var windDirection10m    : Int?    = null,
    @SerialName("wind_gusts_10m"       ) var windGusts10m        : Double? = null
)
