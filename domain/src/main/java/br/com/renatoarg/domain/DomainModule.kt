package br.com.renatoarg.domain

import br.com.renatoarg.domain.interactor.GetUserUseCase
import br.com.renatoarg.domain.interactor.ListUserUseCase
import br.com.renatoarg.domain.interactor.RegisterUserUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {
    private val domain = module {
        factory { ListUserUseCase(get()) }
        factory { GetUserUseCase(get()) }
        factory { RegisterUserUseCase(get()) }
    }

    fun loadModule() {
        loadKoinModules(domain)
    }
}