package br.com.renatoarg.data.cloud.api

import br.com.renatoarg.data.cloud.model.response.UsersListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi {

    @GET("api/users")
    suspend fun getUsersList(@Query("page") page: Int): UsersListResponse
}