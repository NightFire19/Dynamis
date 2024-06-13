package domain

import domain.model.DataModel
import domain.model.ForecastResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getIt() : Flow<Result<DataModel>>
    fun getWeather(): Flow<Result<ForecastResponse>>
}