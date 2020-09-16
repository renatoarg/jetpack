package br.com.renatoarg.data.di

import br.com.renatoarg.data.cloud.api.ReqresApi
import br.com.renatoarg.data.infra.network.BaseUrl
import br.com.renatoarg.data.infra.network.OkHttp
import br.com.renatoarg.data.infra.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideReqresApi(): ReqresApi =
        RetrofitBuilder.buildRetrofit(
            apiClass = ReqresApi::class.java,
            baseUrl = BaseUrl.getBaseUrlCustom(),
            client = OkHttp.getOkHttp()
        )
}