package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits (

    @SerialName("time"                      ) var time                     : String? = null,
    @SerialName("temperature_2m"            ) var temperature2m            : String? = null,
    @SerialName("relative_humidity_2m"      ) var relativeHumidity2m       : String? = null,
    @SerialName("dew_point_2m"              ) var dewPoint2m               : String? = null,
    @SerialName("apparent_temperature"      ) var apparentTemperature      : String? = null,
    @SerialName("precipitation_probability" ) var precipitationProbability : String? = null,
    @SerialName("precipitation"             ) var precipitation            : String? = null,
    @SerialName("rain"                      ) var rain                     : String? = null,
    @SerialName("showers"                   ) var showers                  : String? = null,
    @SerialName("snowfall"                  ) var snowfall                 : String? = null,
    @SerialName("snow_depth"                ) var snowDepth                : String? = null,
    @SerialName("weather_code"              ) var weatherCode              : String? = null,
    @SerialName("surface_pressure"          ) var surfacePressure          : String? = null,
    @SerialName("cloud_cover"               ) var cloudCover               : String? = null,
    @SerialName("visibility"                ) var visibility               : String? = null,
    @SerialName("wind_speed_10m"            ) var windSpeed10m             : String? = null,
    @SerialName("wind_direction_10m"        ) var windDirection10m         : String? = null,
    @SerialName("wind_gusts_10m"            ) var windGusts10m             : String? = null,
    @SerialName("uv_index"                  ) var uvIndex                  : String? = null,
    @SerialName("is_day"                    ) var isDay                    : String? = null,
    @SerialName("sunshine_duration"         ) var sunshineDuration         : String? = null

)