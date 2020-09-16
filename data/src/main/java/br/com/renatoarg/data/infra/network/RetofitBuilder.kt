package br.com.renatoarg.data.infra.network

import br.com.renatoarg.data.API_DATE_FORMAT
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val gson = GsonBuilder()
        .serializeNulls()
        .setDateFormat(API_DATE_FORMAT)
        .create()
    fun <T> buildRetrofit(apiClass: Class<T>, baseUrl: String, client: OkHttpClient.Builder) : T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
            .create(apiClass)
    }
}