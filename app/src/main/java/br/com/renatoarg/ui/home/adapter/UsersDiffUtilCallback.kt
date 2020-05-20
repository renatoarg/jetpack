package br.com.renatoarg.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.renatoarg.model.pojo.User

class UsersDiffUtilCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}