package com.jemykeefa.keefamovies.di.modules

import com.jemykeefa.keefamovies.data.model.reposirtory.DetailsRepository
import com.jemykeefa.keefamovies.data.model.reposirtory.MoviesListRepository
import com.jemykeefa.keefamovies.data.model.reposirtory.SuggestionsRepository
import com.jemykeefa.keefamovies.ui.home.HomeViewModelFactory
import com.jemykeefa.keefamovies.ui.moviedetails.details.DetailsViewModelFactory
import com.jemykeefa.keefamovies.ui.moviedetails.suggestions.suggestions.SuggestionsViewModelFactory
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

    @Provides
    @Singleton
    fun getDetailsViewModelFactory(
        detailsRepository: DetailsRepository
    ): DetailsViewModelFactory = DetailsViewModelFactory(detailsRepository)

    @Provides
    @Singleton
    fun getSuggestionsViewModelFactory(
        suggestionRepository: SuggestionsRepository
    ): SuggestionsViewModelFactory = SuggestionsViewModelFactory(suggestionRepository)


}