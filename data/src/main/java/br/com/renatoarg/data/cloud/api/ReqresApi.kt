package br.com.renatoarg.data.cloud.api

import br.com.renatoarg.data.cloud.model.request.RegisterRequest
import br.com.renatoarg.data.cloud.model.response.RegisterResponse
import br.com.renatoarg.data.cloud.model.response.UserResponse
import br.com.renatoarg.data.cloud.model.response.UsersListResponse
import retrofit2.http.*

interface ReqresApi {

    @GET("api/users")
    suspend fun getUsersList(@Query("page") page: Int): UsersListResponse

    @GET("api/users/{userId}")
    suspend fun singleUserById(@Path("userId") userId: Long): UserResponse

    @POST("api/register")
    suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse
}