package com.jemykeefa.keefamovies.ui.moviedetails.suggestions.suggestions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jemykeefa.keefamovies.data.model.reposirtory.SuggestionsRepository
import com.jemykeefa.keefamovies.ui.home.HomeViewModel
import javax.inject.Inject

class SuggestionsViewModelFactory @Inject constructor(
    private val moviesSuggestionsRepository: SuggestionsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SuggestionsViewModel::class.java)) {
            return SuggestionsViewModel(
                moviesSuggestionsRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown class name need ${SuggestionsViewModel::class.java.simpleName} instance")
    }

}