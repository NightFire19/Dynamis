package domain

import domain.model.DataModel
import domain.model.ForecastResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getWeather(latitude: Double, longitude: Double): Flow<Result<ForecastResponse>>
}