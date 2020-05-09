package br.com.renatoarg.model

import br.com.renatoarg.model.response.UsersListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ReqresRepository(reqresClient: ReqresClient) {

    private val api = reqresClient

    fun getUsers() {
        val call = api.api.getUsersList(1)
        call.enqueue(object: Callback<UsersListResponse> {
            override fun onFailure(call: Call<UsersListResponse>, t: Throwable) {
                Timber.d("onFailure:")
            }

            override fun onResponse(
                call: Call<UsersListResponse>,
                response: Response<UsersListResponse>
            ) {
                Timber.d("onResponse:")
                Timber.d("list: ${response.body() as UsersListResponse}")
            }

        })
    }
}