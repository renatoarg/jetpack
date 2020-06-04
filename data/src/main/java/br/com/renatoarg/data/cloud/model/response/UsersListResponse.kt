package br.com.renatoarg.data.cloud.model.response

import com.google.gson.annotations.SerializedName


data class UsersListResponse(
    @SerializedName("data") val data: List<UserResponse> = emptyList()
)