package br.com.renatoarg.domain.interactor

import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.repository.IReqresRepository
import br.com.renatoarg.domain.repository.Resource

class RegisterUserUseCase constructor(
    private val repository: IReqresRepository
) {
    suspend fun execute(email : String?, password : String?): Resource<Exception, User> {
        return repository.registerUser(email, password)
    }
}