package br.com.renatoarg.data.infra.network

import br.com.renatoarg.data.BuildConfig

object BaseUrl {
    fun getBaseUrlCustom(): String {
        return BuildConfig.API_URL
    }
}