package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataModel(
    @SerialName("userId") val userId: Int = 0,
    @SerialName("id") val id: Int = 0,
    @SerialName("title") val title: String = "empty",
    @SerialName("completed") val completed: Boolean = false,
)
