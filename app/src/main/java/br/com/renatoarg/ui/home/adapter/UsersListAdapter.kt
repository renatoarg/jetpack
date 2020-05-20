package br.com.renatoarg.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.viewholder.ErrorViewHolder
import br.com.renatoarg.ui.home.adapter.viewholder.UserOkViewHolder
import br.com.renatoarg.ui.home.adapter.viewholder.UsersListInterface
import br.com.renatoarg.ui.home.adapter.viewholder.UsersViewHolder

class UsersListAdapter(
    private val usersInterface: UsersListInterface
) : ListAdapter<User, UsersViewHolder>(UsersDiffUtilCallback()) {

    companion object {
        private const val TYPE_OK = 0
        private const val TYPE_ERROR = 100
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return when(viewType) {
            TYPE_OK -> UserOkViewHolder(parent, usersInterface)
            TYPE_ERROR -> ErrorViewHolder(parent, usersInterface)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val firstNameSize = getItem(position).first_name?.length ?: 0
        return when(firstNameSize){
            in 0 .. 5 -> TYPE_OK
            else -> TYPE_ERROR
        }

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
