package br.com.renatoarg.data.infra.interceptors

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY

object Logger {
    fun getHttpLogger() : HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = BODY
        return  logger
    }

    fun getStetho(): StethoInterceptor {
        return StethoInterceptor()
    }
}