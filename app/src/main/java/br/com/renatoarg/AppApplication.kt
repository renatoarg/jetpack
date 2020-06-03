package br.com.renatoarg

import android.app.Application
import br.com.renatoarg.commons.homeModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // setup timber
        Timber.plant(Timber.DebugTree())

        // setup koin
        startKoin {
            androidContext(this@AppApplication)
            modules(homeModule)
        }

        initializeStetho()
    }

    private fun initializeStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}