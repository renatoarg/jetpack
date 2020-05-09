package br.com.renatoarg.model.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int? = null,
    val email: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val avatar: String? = null
) : Parcelable