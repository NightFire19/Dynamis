package data.repo

import domain.ApiService
import domain.Repository
import domain.model.DataModel
import domain.model.ForecastResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class RepositoryImplementation(
    private val apiService: ApiService
) : Repository {
    override fun getWeather(latitude: Double, longitude: Double): Flow<Result<ForecastResponse>> =
        apiService.getWeather(latitude = latitude, longitude = longitude).catch { e ->
            emit(Result.failure(e))
        }
}