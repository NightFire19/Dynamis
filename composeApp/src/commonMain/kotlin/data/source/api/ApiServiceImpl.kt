package data.source.api

import domain.ApiService
import domain.model.DataModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
class ApiServiceImpl(val httpClient: HttpClient) : ApiService {
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
                        Error("my error message", Throwable())
                    )
                )
            }
        }
}