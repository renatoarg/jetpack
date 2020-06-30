package br.com.renatoarg.domain.repository

import br.com.renatoarg.domain.model.User

interface IReqresRepository {
    suspend fun getUsersData(page: Int) : Resource<Exception, List<User>>
    suspend fun getUser(userId : Long) : Resource<Exception, User>
    suspend fun registerUser(email : String?, password: String?) : Resource<Exception, User>
}