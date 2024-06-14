package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    @SerialName("time"                      ) var time                     : ArrayList<String> = arrayListOf(),
    @SerialName("temperature_2m"            ) var temperature2m            : ArrayList<Double> = arrayListOf(),
    @SerialName("relative_humidity_2m"      ) var relativeHumidity2m       : ArrayList<Int>    = arrayListOf(),
    @SerialName("dew_point_2m"              ) var dewPoint2m               : ArrayList<Double> = arrayListOf(),
    @SerialName("apparent_temperature"      ) var apparentTemperature      : ArrayList<Double> = arrayListOf(),
    @SerialName("precipitation_probability" ) var precipitationProbability : ArrayList<Int>    = arrayListOf(),
    @SerialName("precipitation"             ) var precipitation            : ArrayList<Double> = arrayListOf(),
    @SerialName("rain"                      ) var rain                     : ArrayList<Double> = arrayListOf(),
    @SerialName("showers"                   ) var showers                  : ArrayList<Double> = arrayListOf(),
    @SerialName("snowfall"                  ) var snowfall                 : ArrayList<Double> = arrayListOf(),
    @SerialName("snow_depth"                ) var snowDepth                : ArrayList<Double> = arrayListOf(),
    @SerialName("weather_code"              ) var weatherCode              : ArrayList<Int>    = arrayListOf(),
    @SerialName("surface_pressure"          ) var surfacePressure          : ArrayList<Double> = arrayListOf(),
    @SerialName("cloud_cover"               ) var cloudCover               : ArrayList<Int>    = arrayListOf(),
    @SerialName("visibility"                ) var visibility               : ArrayList<Double> = arrayListOf(),
    @SerialName("wind_speed_10m"            ) var windSpeed10m             : ArrayList<Double> = arrayListOf(),
    @SerialName("wind_direction_10m"        ) var windDirection10m         : ArrayList<Int>    = arrayListOf(),
    @SerialName("wind_gusts_10m"            ) var windGusts10m             : ArrayList<Double> = arrayListOf(),
    @SerialName("uv_index"                  ) var uvIndex                  : ArrayList<Double> = arrayListOf(),
    @SerialName("is_day"                    ) var isDay                    : ArrayList<Int>    = arrayListOf(),
    @SerialName("sunshine_duration"         ) var sunshineDuration         : ArrayList<Double> = arrayListOf(),
)
