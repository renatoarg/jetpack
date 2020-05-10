package br.com.renatoarg.model

class ReqresRepository(reqresClient: ReqresClient) {

    private val api = reqresClient

    suspend fun getUsers() = api.api.getUsersList(1)

}