package br.com.renatoarg.ui.home

import br.com.renatoarg.domain.model.User

sealed class HomeState {

    object Init: HomeState()

    object Loading: HomeState()

    class UsersLoaded(val users: List<User>) : HomeState()

    class UserLoaded(val user: User) : HomeState()

    class UserRegistered(val user: User) : HomeState()

    object Navigate : HomeState()

    class ErrorOnRegister(val e: Exception) : HomeState()

    class Error(error: Exception) : HomeState()

}