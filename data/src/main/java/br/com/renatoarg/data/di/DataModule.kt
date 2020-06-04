package br.com.renatoarg.data.di

import br.com.renatoarg.data.cloud.ReqresCloud
import br.com.renatoarg.data.cloud.ReqresRepositoryData
import br.com.renatoarg.data.cloud.api.ReqresApi
import br.com.renatoarg.data.infra.network.BaseUrl
import br.com.renatoarg.data.infra.network.RetrofitBuilder
import br.com.renatoarg.domain.repository.IReqresRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DataModule {

    private val module = module {
        single { RetrofitBuilder().buildRetrofit(
            apiClass = ReqresApi::class.java,
            baseUrl = BaseUrl.getBaseUrlCustom()) }
        single { ReqresCloud(get()) }
        single<IReqresRepository> { ReqresRepositoryData(get()) }
    }

    fun loadModule() {
        loadKoinModules(module)
    }
}