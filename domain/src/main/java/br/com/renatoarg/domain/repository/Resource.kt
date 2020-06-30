package br.com.renatoarg.domain.repository

/**
 * Result Wrapper <Left = Exception, Right = Value/Success>
 */
sealed class Resource<out F, out V> {

    data class Value<out V>(val value: V) : Resource<Nothing, V>()
    data class Error<out E>(val error: E) : Resource<E, Nothing>()

    companion object Factory {
        inline fun <V> build(function: () -> V): Resource<Exception, V> =
            try {
                Value(function.invoke())
            } catch (e: Exception) {
                Error(e)
            }
    }
}