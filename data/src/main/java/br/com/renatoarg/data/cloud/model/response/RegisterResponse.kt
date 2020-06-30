package br.com.renatoarg.data.cloud.model.response

import com.google.gson.annotations.SerializedName


data class RegisterResponse (
    @SerializedName("id") val id: Int? = null,
    @SerializedName("token") val token: String? = null
)