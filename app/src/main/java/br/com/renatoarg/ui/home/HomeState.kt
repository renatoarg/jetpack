package br.com.renatoarg.ui.home

import android.widget.ImageView
import br.com.renatoarg.model.pojo.User

sealed class HomeState {

    object Init: HomeState()

    data class  NavigateToUserDetail(
        val photo: ImageView
    ) : HomeState()

    data class UsersLoaded(
        val usersList: List<User>
    ) : HomeState()

    data class SelectUser(
        val user: User
    ) : HomeState()

}