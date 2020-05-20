package br.com.renatoarg.ui.home.adapter.viewholder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.renatoarg.R
import br.com.renatoarg.model.pojo.User
import br.com.renatoarg.ui.home.adapter.UsersListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_user.view.*

class UserOkViewHolder(
    parent: ViewGroup,
    usersInterface: UsersListInterface
) : UsersViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false),
    usersInterface
)

