package br.com.renatoarg.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ReqresClient {
    val api: ReqresApi
        get() {
            // Http client
            val client = OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.MINUTES)

            // OkHttp logger
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logger)

            // http connection
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build()).build()
            return retrofit.create(ReqresApi::class.java)
        }
}
