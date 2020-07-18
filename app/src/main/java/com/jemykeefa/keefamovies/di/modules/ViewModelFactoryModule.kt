package com.jemykeefa.keefamovies.di.modules

import com.jemykeefa.keefamovies.data.model.reposirtory.MoviesListRepository
import com.jemykeefa.keefamovies.ui.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun getHomeViewModelFactory(
        popularRepository: MoviesListRepository
    ): HomeViewModelFactory = HomeViewModelFactory(popularRepository)

}