package di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import ui.screen.home.HomeViewModel

fun appModule() : List<Module> = listOf(providesHomeViewModel)

val providesHomeViewModel = module {
    viewModelOf(::HomeViewModel)
}