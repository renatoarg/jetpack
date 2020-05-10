package br.com.renatoarg.model

import br.com.renatoarg.model.response.UsersListResponse
import io.reactivex.Observable

class ReqresRepository(reqresClient: ReqresClient) {

    private val api = reqresClient

    fun getUsers(): Observable<UsersListResponse> {
        return api.api.getUsersList(1)
    }
}