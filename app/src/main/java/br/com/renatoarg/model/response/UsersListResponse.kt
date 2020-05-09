package br.com.renatoarg.model.response

import android.os.Parcelable
import br.com.renatoarg.model.pojo.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersListResponse(
    val page: Int = 0,
    val per_page: Int = 0,
    val total: Int = 0,
    val total_pages: Int = 0,
    val data: List<User> = emptyList()
) : Parcelable