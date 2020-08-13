package com.jemykeefa.keefamovies.di.component

import com.jemykeefa.keefamovies.MovieApplication
import com.jemykeefa.keefamovies.di.modules.ApiModule
import com.jemykeefa.keefamovies.di.modules.AppModule
import com.jemykeefa.keefamovies.di.modules.NetworkModule
import com.jemykeefa.keefamovies.di.modules.ViewModelFactoryModule
import com.jemykeefa.keefamovies.ui.home.HomeFragment
import com.jemykeefa.keefamovies.ui.moviedetails.TabLayoutFragment
import com.jemykeefa.keefamovies.ui.moviedetails.details.DetailsFragment
import com.jemykeefa.keefamovies.ui.moviedetails.suggestions.suggestions.SuggestionsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ApiModule::class]
)
interface AppComponent {

    fun inject(app: MovieApplication)

    fun inject(homeFragment: HomeFragment)

    fun inject(movieDetailsFragment: TabLayoutFragment)

    fun inject(detailsFragment: DetailsFragment)

    fun inject(suggestionsFragment: SuggestionsFragment)
}