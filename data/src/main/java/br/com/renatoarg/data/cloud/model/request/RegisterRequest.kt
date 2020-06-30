package br.com.renatoarg.data.cloud.model.request

import com.google.gson.annotations.SerializedName


data class RegisterRequest (
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null
)