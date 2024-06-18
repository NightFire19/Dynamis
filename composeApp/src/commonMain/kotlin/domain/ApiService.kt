package domain

import domain.model.DataModel
import domain.model.ForecastResponse
import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun getThing(): Flow<Result<DataModel>>
    fun getWeather(
        latitude: Double,
        longitude: Double
    ): Flow<Result<ForecastResponse>>
}