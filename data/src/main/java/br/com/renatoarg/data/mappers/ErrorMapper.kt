package br.com.renatoarg.data.mappers

import org.json.JSONObject
import retrofit2.HttpException

object ErrorMapper {
    private fun parseHttpException(e: HttpException) : String {
        return try {
            val errorBody: String? = e.response()?.errorBody()?.string()
            if (errorBody != null) {
                JSONObject(errorBody).getString("error")
            } else {
                "Unable to parse error"
            }
        } catch (e: Exception) {
            "Unable to parse error"
        }
    }

    fun transform(e: Exception) : String {
        return when (e) {
            is HttpException -> parseHttpException(e)
            else -> e.message.orEmpty()
        }
    }
}


