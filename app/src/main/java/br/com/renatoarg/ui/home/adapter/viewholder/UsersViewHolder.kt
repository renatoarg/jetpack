package br.com.renatoarg.ui.home.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user.view.*

abstract class UsersViewHolder(
    itemView : View,
    private val usersInterface: UsersListInterface
) : RecyclerView.ViewHolder(itemView) {
    open fun bind(user : User){
        with(itemView){

            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().circleCrop())
                .into(photo)

            name.text = itemView.context.getString(R.string.user_name, user.first_name, user.last_name)
            email.text = user.email
            wrapper.setOnClickListener {
                usersInterface.selectUser(user, photo)
            }
        }
    }
}