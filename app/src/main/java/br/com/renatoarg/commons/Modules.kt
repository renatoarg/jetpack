package br.com.renatoarg.commons

import br.com.renatoarg.model.ReqresClient
import br.com.renatoarg.model.ReqresRepository
import br.com.renatoarg.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module(override = true) {
    single { ReqresClient() }
    single { ReqresRepository(get()) }
    viewModel { HomeViewModel(get()) }
}