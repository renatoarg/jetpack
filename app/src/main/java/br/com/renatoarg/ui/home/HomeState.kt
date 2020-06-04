package br.com.renatoarg.ui.home

import br.com.renatoarg.domain.model.User

sealed class HomeState {

    object Init: HomeState()

    object Loading: HomeState()

    class UsersLoaded(val users: List<User>) : HomeState()

    object Navigate : HomeState()

}