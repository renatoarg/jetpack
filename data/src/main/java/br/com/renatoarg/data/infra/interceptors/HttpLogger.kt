package br.com.renatoarg.data.infra.interceptors

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY

object HttpLogger {
    fun getHttpLogger() : HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = BODY
        return  logger
    }
}