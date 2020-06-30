package br.com.renatoarg.data.infra.connection

import br.com.renatoarg.data.BuildConfig
import br.com.renatoarg.data.infra.interceptors.HttpLogger
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

class RetrofitBuilder {
    fun <T> buildRetrofit(apiClass: Class<T>) : T {
        val client = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.MINUTES)

        client.addInterceptor(HttpLogger().getHttpLogger())
//        client.addInterceptor(BadRequestInterceptor())

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(apiClass)
    }
}

class BadRequestInterceptor : Interceptor {

    override fun intercept(chain : Interceptor.Chain) : Response {
        val request : Request = chain.request()
        val response = chain.proceed(request)

        if (response.code() == 400) {
//            response.errorBody()
        }


        return response
    }
}