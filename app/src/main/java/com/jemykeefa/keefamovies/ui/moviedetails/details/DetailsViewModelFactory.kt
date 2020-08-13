package com.jemykeefa.keefamovies.ui.moviedetails.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jemykeefa.keefamovies.data.model.reposirtory.DetailsRepository
import com.jemykeefa.keefamovies.ui.home.HomeViewModel
import javax.inject.Inject

class DetailsViewModelFactory @Inject constructor(
    private val movieDetailsRepository: DetailsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(movieDetailsRepository) as T
        }
        throw IllegalArgumentException("Unknown class name need ${DetailsViewModel::class.java.simpleName} instance")
    }

}