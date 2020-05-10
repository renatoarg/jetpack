package br.com.renatoarg.model

import br.com.renatoarg.model.response.UsersListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ReqresApi {

    @GET("api/users")
    suspend fun getUsersList(@Query("page") page: Int): UsersListResponse

}