package br.com.renatoarg.model

import br.com.renatoarg.model.response.UsersListResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi {

    @GET("api/users")
    fun getUsersList(@Query("page") page: Int): Observable<UsersListResponse>

}