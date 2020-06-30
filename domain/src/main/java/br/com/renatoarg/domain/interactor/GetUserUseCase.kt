package br.com.renatoarg.domain.interactor

import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository
import br.com.renatoarg.domain.repository.Resource

class GetUserUseCase constructor(
    private val repository: IReqresRepository
) {
    private var userId = 23L

    suspend fun execute(): Resource<Exception, User> {
        return repository.getUser(userId)
    }
}