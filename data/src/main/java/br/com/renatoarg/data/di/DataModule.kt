package br.com.renatoarg.data.di

import br.com.renatoarg.data.cloud.ReqresCloud
import br.com.renatoarg.data.cloud.ReqresRepositoryData
import br.com.renatoarg.data.cloud.api.ReqresApi
import br.com.renatoarg.data.infra.connection.RetrofitBuilder
import br.com.renatoarg.domain.repository.IReqresRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataModule {

    private val module = module {
        single { RetrofitBuilder().buildRetrofit(ReqresApi::class.java) }
        single { ReqresCloud(get()) }
        single<IReqresRepository> { ReqresRepositoryData(get()) }
    }

    fun loadModule() {
        loadKoinModules(module)
    }
}