package br.com.renatoarg.domain

import br.com.renatoarg.domain.interactor.ListUserUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {
    private val domain = module {
        factory { ListUserUseCase(get()) }
    }

    fun loadModule() {
        loadKoinModules(domain)
    }
}