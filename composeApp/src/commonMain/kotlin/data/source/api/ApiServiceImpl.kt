package data.source.api

import data.source.api.ApiConstants.ParameterValues.DEFAULT_PRECIPITATION_UNIT
import data.source.api.ApiConstants.ParameterValues.DEFAULT_TEMPERATURE_UNIT
import data.source.api.ApiConstants.ParameterValues.DEFAULT_TIMEZONE
import data.source.api.ApiConstants.ParameterValues.DEFAULT_WIND_SPEED_UNIT
import domain.ApiService
import domain.model.DataModel
import domain.model.ForecastResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
class ApiServiceImpl(private val httpClient: HttpClient) : ApiService {
    override fun getThing(): Flow<Result<DataModel>> =
        flow {
            try {
                val response = httpClient
                    .get("https://jsonplaceholder.typicode.com/todos/1")
                    .body<DataModel>()
                emit(Result.success(response))
            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(
                    Result.failure(
                        Error(exception.message, exception)
                    )
                )
            }
        }

    override fun getWeather(): Flow<Result<ForecastResponse>> =
        flow {
            try {
                val response = httpClient.get("https://api.open-meteo.com/v1/forecast") {
                    url {
                        parameters.append("latitude", "33.189189")
                        parameters.append("longitude", "-96.649555")
                        parameters.append("current", "temperature_2m")
                        parameters.append("temperature_unit", DEFAULT_TEMPERATURE_UNIT)
                        parameters.append("wind_speed_unit", DEFAULT_WIND_SPEED_UNIT)
                        parameters.append("precipitation_unit", DEFAULT_PRECIPITATION_UNIT)
                        parameters.append("timezone", DEFAULT_TIMEZONE)
                    }
                }
                    .body<ForecastResponse>()
                emit(Result.success(response))
            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(
                    Result.failure(
                        Error(exception.message, exception)
                    )
                )
            }
        }
}