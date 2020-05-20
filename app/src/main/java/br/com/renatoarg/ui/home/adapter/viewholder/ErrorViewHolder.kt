package br.com.renatoarg.ui.home.adapter.viewholder
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.set
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user.view.*

class ErrorViewHolder(
    parent: ViewGroup,
    usersInterface: UsersListInterface
) : UsersViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_error, parent, false),
    usersInterface
) {

    override fun bind(user: User) {
        super.bind(user)
        val name = itemView.name.text
        val spannableString = SpannableString(name)
        spannableString.setSpan(
            StrikethroughSpan(),
            0,
            user.first_name?.length ?: 0,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        itemView.name.text = spannableString
    }

}

