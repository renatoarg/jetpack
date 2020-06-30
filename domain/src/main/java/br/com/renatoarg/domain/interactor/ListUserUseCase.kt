package br.com.renatoarg.domain.interactor

import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository
import br.com.renatoarg.domain.repository.Resource

class ListUserUseCase constructor(
    private val repository: IReqresRepository
) {
    private var countPage = 1

    suspend fun execute(): Resource<Exception, List<User>> {
        return repository.getUsersData(countPage++)
    }
}