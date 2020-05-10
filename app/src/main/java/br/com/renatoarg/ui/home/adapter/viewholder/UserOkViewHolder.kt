package br.com.renatoarg.ui.home.adapter.viewholder
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.UsersListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserOkViewHolder(
    itemView: View,
    var usersInterface: UsersListInterface
) :
        UsersListAdapter.BaseViewHolder<User>(itemView) {

    override fun bind(item: User) {
        val photo = itemView.findViewById<ImageView>(R.id.photo)
        Glide.with(itemView.context).load(item.avatar).apply(RequestOptions().circleCrop()).into(photo)
        itemView.findViewById<TextView>(R.id.name).text = itemView.context.getString(R.string.user_name, item.first_name, item.last_name)
        itemView.findViewById<TextView>(R.id.email).text = item.email
        itemView.findViewById<ConstraintLayout>(R.id.wrapper).setOnClickListener {
            usersInterface.selectUser(item, photo)
        }
    }

}

