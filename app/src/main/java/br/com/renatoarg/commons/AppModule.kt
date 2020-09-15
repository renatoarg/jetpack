package br.com.renatoarg.commons

import android.content.Context
import br.com.renatoarg.model.ReqresClient
import br.com.renatoarg.model.ReqresRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRepository() = ReqresRepository(ReqresClient())

    @Singleton
    @Provides
    fun provideSharedPrefs(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

}