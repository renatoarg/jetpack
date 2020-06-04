package br.com.renatoarg.data.cloud

import br.com.renatoarg.data.mappers.ResponseListToUserMapper
import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository

class ReqresRepositoryData(
    private val cloud: ReqresCloud
) : IReqresRepository {

    private val mapper = ResponseListToUserMapper()

    override suspend fun getUsersData(page: Int): List<User> {
        val users = cloud.getUsers(page)
        return mapper.transform(users)
    }
}