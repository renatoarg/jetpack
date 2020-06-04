package br.com.renatoarg.domain.model

import java.io.Serializable

data class User(
    val id: Int? = null,
    val email: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val avatar: String? = null
): Serializable