package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    @SerialName("latitude"              ) var latitude             : Double?      = null,
    @SerialName("longitude"             ) var longitude            : Double?      = null,
    @SerialName("generationtime_ms"     ) var generationtimeMs     : Double?      = null,
    @SerialName("utc_offset_seconds"    ) var utcOffsetSeconds     : Int?         = null,
    @SerialName("timezone"              ) var timezone             : String?      = null,
    @SerialName("timezone_abbreviation" ) var timezoneAbbreviation : String?      = null,
    @SerialName("elevation"             ) var elevation            : Double?      = null,
    @SerialName("hourly_units"          ) var hourlyUnits          : HourlyUnits? = HourlyUnits(),
    @SerialName("hourly"                ) var hourly               : Hourly?      = Hourly(),
    @SerialName("daily_units"           ) var dailyUnits           : DailyUnits?  = DailyUnits(),
    @SerialName("daily"                 ) var daily                : Daily?       = Daily(),
    @SerialName("current_units"         ) var currentUnits         : CurrentUnits? = CurrentUnits(),
    @SerialName("current"               ) var current              : Current?      = Current(),
    )
