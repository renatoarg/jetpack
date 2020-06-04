package br.com.renatoarg.data.infra.network

import br.com.renatoarg.data.infra.interceptors.HttpLogger
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {
    fun <T> buildRetrofit(apiClass: Class<T>, baseUrl: String) : T {
        val client = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.MINUTES)

        client.addInterceptor(HttpLogger.getHttpLogger())

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(apiClass)
    }
}