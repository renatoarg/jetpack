package br.com.renatoarg.di

import br.com.renatoarg.data.repository.ReqresRepository
import br.com.renatoarg.domain.repository.IReqresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindReqresRepository(reqresRepository: ReqresRepository): IReqresRepository
}