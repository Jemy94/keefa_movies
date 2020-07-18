package com.jemykeefa.keefamovies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jemykeefa.keefamovies.data.model.reposirtory.MoviesListRepository
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val moviesListRepository: MoviesListRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(moviesListRepository) as T
        }
        throw IllegalArgumentException("Unknown class name need ${HomeViewModel::class.java.simpleName} instance")
    }

}