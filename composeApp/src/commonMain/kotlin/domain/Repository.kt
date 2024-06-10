package domain

import domain.model.DataModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getIt() : Flow<Result<DataModel>>
}