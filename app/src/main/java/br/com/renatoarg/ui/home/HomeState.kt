package br.com.renatoarg.ui.home

import br.com.renatoarg.model.pojo.User

sealed class HomeState {

    object Init: HomeState()

    object Loading: HomeState()

    data class UsersLoaded(
        val usersList: List<User>
    ) : HomeState()

    object Navigate : HomeState()

}