package br.com.renatoarg.data.repository

import br.com.renatoarg.data.cloud.ReqresCloud
import br.com.renatoarg.data.mappers.ResponseListToUserMapper
import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository
import javax.inject.Inject

class ReqresRepository @Inject constructor(
    private val cloud: ReqresCloud
) : IReqresRepository {

    private val mapper = ResponseListToUserMapper()

    override suspend fun getUsersData(page: Int): List<User> {
        val users = cloud.getUsers(page)
        return mapper.transform(users)
    }
}