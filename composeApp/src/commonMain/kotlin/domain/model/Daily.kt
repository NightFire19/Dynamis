package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("time"                          ) var time                        : ArrayList<String> = arrayListOf(),
    @SerialName("weather_code"                  ) var weatherCode                 : ArrayList<Int>    = arrayListOf(),
    @SerialName("temperature_2m_max"            ) var temperature2mMax            : ArrayList<Double> = arrayListOf(),
    @SerialName("temperature_2m_min"            ) var temperature2mMin            : ArrayList<Double> = arrayListOf(),
    @SerialName("apparent_temperature_max"      ) var apparentTemperatureMax      : ArrayList<Double> = arrayListOf(),
    @SerialName("apparent_temperature_min"      ) var apparentTemperatureMin      : ArrayList<Int>    = arrayListOf(),
    @SerialName("sunrise"                       ) var sunrise                     : ArrayList<String> = arrayListOf(),
    @SerialName("sunset"                        ) var sunset                      : ArrayList<String> = arrayListOf(),
    @SerialName("daylight_duration"             ) var daylightDuration            : ArrayList<Double> = arrayListOf(),
    @SerialName("sunshine_duration"             ) var sunshineDuration            : ArrayList<Double> = arrayListOf(),
    @SerialName("uv_index_max"                  ) var uvIndexMax                  : ArrayList<Double> = arrayListOf(),
    @SerialName("precipitation_sum"             ) var precipitationSum            : ArrayList<Double> = arrayListOf(),
    @SerialName("rain_sum"                      ) var rainSum                     : ArrayList<Double> = arrayListOf(),
    @SerialName("showers_sum"                   ) var showersSum                  : ArrayList<Int>    = arrayListOf(),
    @SerialName("snowfall_sum"                  ) var snowfallSum                 : ArrayList<Int>    = arrayListOf(),
    @SerialName("precipitation_probability_max" ) var precipitationProbabilityMax : ArrayList<Int>    = arrayListOf(),
    @SerialName("wind_speed_10m_max"            ) var windSpeed10mMax             : ArrayList<Double> = arrayListOf(),
    @SerialName("wind_gusts_10m_max"            ) var windGusts10mMax             : ArrayList<Double> = arrayListOf(),
    @SerialName("wind_direction_10m_dominant"   ) var windDirection10mDominant    : ArrayList<Int>    = arrayListOf()
)