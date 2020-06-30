package br.com.renatoarg.data.cloud

import br.com.renatoarg.data.cloud.model.request.RegisterRequest
import br.com.renatoarg.data.mappers.ErrorMapper
import br.com.renatoarg.data.mappers.UsersMapper
import br.com.renatoarg.domain.model.User
import br.com.renatoarg.domain.exception.DomainException
import br.com.renatoarg.domain.repository.IReqresRepository
import br.com.renatoarg.domain.exception.RegisterUserException
import br.com.renatoarg.domain.repository.Resource

class ReqresRepositoryData(
    private val cloud: ReqresCloud
) : IReqresRepository {

    override suspend fun getUsersData(page: Int): Resource<Exception, List<User>> {
        return try {
            val response = cloud.getUsers(page)
            Resource.build { UsersMapper.transform(response) }
        } catch (e: Exception) {
            Resource.build { throw DomainException(
                e
            )
            }
        }
    }

    override suspend fun getUser(userId: Long): Resource<Exception, User> {
        return try {
            val response = cloud.singleUserById(userId)
            Resource.build { UsersMapper.transform(response) }
        } catch (e: Exception) {
            Resource.build { throw DomainException(
                e
            )
            }
        }
    }

    override suspend fun registerUser(
        email: String?,
        password: String?
    ): Resource<Exception, User> {
        return try {
            val response = cloud.register(RegisterRequest(email, password))
            Resource.build { UsersMapper.transform(response) }
        } catch (e: Exception) {
            Resource.build { throw RegisterUserException(
                ErrorMapper.transform(e)
            )
            }
        }
    }
}