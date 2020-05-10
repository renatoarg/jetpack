package br.com.renatoarg.ui.home.adapter.viewholder

import android.widget.ImageView
import br.com.renatoarg.model.pojo.User

interface UsersListInterface {
    fun selectUser(user: User, photo: ImageView)
}