package br.com.renatoarg.domain.interactor

import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository

class ListUserUseCase constructor(
    private val repository: IReqresRepository
) {
    private var countPage = 1

    suspend fun execute(): List<User> {
        return repository.getUsersData(countPage++)
    }
}