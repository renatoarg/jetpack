package br.com.renatoarg.data.cloud

import br.com.renatoarg.data.cloud.api.ReqresApi
import br.com.renatoarg.data.cloud.model.response.UsersListResponse

class ReqresCloud(
    private val api: ReqresApi
) {
    suspend fun getUsers(page: Int): UsersListResponse {
        return api.getUsersList(page)
    }
}