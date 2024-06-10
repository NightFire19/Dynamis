package di

import data.repo.RepositoryImplementation
import data.source.api.ApiServiceImpl
import domain.ApiService
import domain.Repository
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import ui.screen.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


fun appModule() : List<Module> = listOf(providesViewModel, providesHttpClient, providesApiService, providesRepository)

val providesViewModel = module {
    viewModelOf(::HomeViewModel)
}

val providesHttpClient = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                    prettyPrint = true
                    isLenient = true
                    }
                )
            }
        }
    }
}

val providesApiService = module {
    single<ApiService> { ApiServiceImpl(get()) }
}

val providesRepository = module {
    single<Repository> { RepositoryImplementation(get()) }
}