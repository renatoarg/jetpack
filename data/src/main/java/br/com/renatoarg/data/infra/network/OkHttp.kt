package br.com.renatoarg.data.infra.network

import android.annotation.SuppressLint
import br.com.renatoarg.data.BuildConfig
import br.com.renatoarg.data.infra.interceptors.Logger
import okhttp3.OkHttpClient
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object OkHttp {
    fun getOkHttp(): OkHttpClient.Builder {
        val okHttp = getOkHttpStandard()

        if (BuildConfig.DEBUG) {
            setUnsafeOkHttpAndLogs(okHttp)
        }

        return okHttp
    }

    fun getUnsafeOkHttpWithLogs(): OkHttpClient.Builder {
        val okHttp = getOkHttpStandard()
        setUnsafeOkHttpAndLogs(okHttp)
        return okHttp
    }

    private fun getOkHttpStandard(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.MINUTES)
    }

    private fun setUnsafeOkHttpAndLogs(client: OkHttpClient.Builder) {
        client.apply {
            hostnameVerifier { _, _ -> true }
            sslSocketFactory(provideSSLSocketFactory(), trustManager())
            addInterceptor(Logger.getHttpLogger())
            addNetworkInterceptor(Logger.getStetho())
        }
    }

    private fun provideSSLSocketFactory(): SSLSocketFactory {
        val trustManager = trustManager()
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, arrayOf<TrustManager>(trustManager), java.security.SecureRandom())
        return sslContext.socketFactory
    }

    @SuppressLint("TrustAllX509TrustManager")
    private fun trustManager(): X509TrustManager {
        return object : X509TrustManager {
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?
            ) {
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }
}