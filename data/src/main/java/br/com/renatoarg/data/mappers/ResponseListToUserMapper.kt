package br.com.renatoarg.data.mappers

import br.com.renatoarg.data.cloud.model.response.UserResponse
import br.com.renatoarg.data.cloud.model.response.UsersListResponse
import br.com.renatoarg.domain.model.User

class ResponseListToUserMapper {

    fun transform(response: UsersListResponse) : List<User>{
        return response.data.map { converterUsers(it) }
    }

    private fun converterUsers(userResponse: UserResponse) : User {
        return User(
            id = userResponse.id,
            avatar = userResponse.avatar,
            email = userResponse.email,
            firstName = userResponse.firstName,
            lastName = userResponse.lastName
        )
    }
}