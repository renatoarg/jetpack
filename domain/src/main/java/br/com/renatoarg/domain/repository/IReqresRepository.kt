package br.com.renatoarg.domain.repository

import br.com.renatoarg.domain.model.User

interface IReqresRepository {
    suspend fun getUsersData(page: Int) : List<User>
}