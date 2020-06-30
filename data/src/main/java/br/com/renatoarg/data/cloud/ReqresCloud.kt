package br.com.renatoarg.data.cloud

import br.com.renatoarg.data.cloud.api.ReqresApi
import br.com.renatoarg.data.cloud.model.request.RegisterRequest
import br.com.renatoarg.data.cloud.model.response.RegisterResponse
import br.com.renatoarg.data.cloud.model.response.UserResponse
import br.com.renatoarg.data.cloud.model.response.UsersListResponse

class ReqresCloud(
    private val api: ReqresApi
) {
    suspend fun getUsers(page: Int): UsersListResponse {
        return api.getUsersList(page)
    }

    suspend fun singleUserById(userId : Long) : UserResponse {
        return api.singleUserById(userId)
    }

    suspend fun register(registerRequest: RegisterRequest) : RegisterResponse {
        return api.register(registerRequest)
    }
}