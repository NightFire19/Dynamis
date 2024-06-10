package domain

import domain.model.DataModel
import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun getThing(): Flow<Result<DataModel>>
}