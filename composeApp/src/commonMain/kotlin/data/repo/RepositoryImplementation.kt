package data.repo

import domain.ApiService
import domain.Repository
import domain.model.DataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class RepositoryImplementation(
    private val apiService: ApiService
) : Repository {
    override fun getIt(): Flow<Result<DataModel>> =
        apiService.getThing().catch { e ->
            emit(Result.failure(e))
        }
}