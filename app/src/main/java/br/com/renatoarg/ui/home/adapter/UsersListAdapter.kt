package br.com.renatoarg.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.viewholder.UserOkViewHolder
import br.com.renatoarg.ui.home.adapter.viewholder.UsersListInterface

class UsersListAdapter(
    private val context: Context,
    private var users: List<User>,
    private val usersInterface: UsersListInterface
) : RecyclerView.Adapter<UsersListAdapter.BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_OK = 0
        private const val TYPE_ERROR = 100
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when(viewType) {
            TYPE_OK -> UserOkViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_user, parent, false),
                usersInterface
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_OK
    }


    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is UserOkViewHolder -> holder.bind(users[position])
        }
    }

    fun updateUsers(usersList: List<User>) {
        this.users = usersList
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }
}
