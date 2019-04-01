package kb.clockmarket.nl.model

import com.fasterxml.jackson.annotation.JsonProperty

data class WorldClockTimeStamp(
    @JsonProperty("\$id") val id : Int,
    @JsonProperty("currentDateTime") val currentDateTime: String,
    @JsonProperty("utcOffset") val utcOffset: String,
    @JsonProperty("isDayLightSavingsTime") val isDayLightsSavingsTime: Boolean,
    @JsonProperty("dayOfTheWeek") val dayOfTheWeek: String,
    @JsonProperty("timeZoneName") val timeZoneName: String,
    @JsonProperty("currentFileTime") val currentFileTime: Long,
    @JsonProperty("ordinalDate") val ordinalDate: String,
    @JsonProperty("serviceResponse") val serviceResponse: String?
)


