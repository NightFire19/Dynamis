package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DailyUnits(
    @SerialName("time"                          ) var time                        : String? = null,
    @SerialName("weather_code"                  ) var weatherCode                 : String? = null,
    @SerialName("temperature_2m_max"            ) var temperature2mMax            : String? = null,
    @SerialName("temperature_2m_min"            ) var temperature2mMin            : String? = null,
    @SerialName("apparent_temperature_max"      ) var apparentTemperatureMax      : String? = null,
    @SerialName("apparent_temperature_min"      ) var apparentTemperatureMin      : String? = null,
    @SerialName("sunrise"                       ) var sunrise                     : String? = null,
    @SerialName("sunset"                        ) var sunset                      : String? = null,
    @SerialName("daylight_duration"             ) var daylightDuration            : String? = null,
    @SerialName("sunshine_duration"             ) var sunshineDuration            : String? = null,
    @SerialName("uv_index_max"                  ) var uvIndexMax                  : String? = null,
    @SerialName("precipitation_sum"             ) var precipitationSum            : String? = null,
    @SerialName("rain_sum"                      ) var rainSum                     : String? = null,
    @SerialName("showers_sum"                   ) var showersSum                  : String? = null,
    @SerialName("snowfall_sum"                  ) var snowfallSum                 : String? = null,
    @SerialName("precipitation_probability_max" ) var precipitationProbabilityMax : String? = null,
    @SerialName("wind_speed_10m_max"            ) var windSpeed10mMax             : String? = null,
    @SerialName("wind_gusts_10m_max"            ) var windGusts10mMax             : String? = null,
    @SerialName("wind_direction_10m_dominant"   ) var windDirection10mDominant    : String? = null
)
