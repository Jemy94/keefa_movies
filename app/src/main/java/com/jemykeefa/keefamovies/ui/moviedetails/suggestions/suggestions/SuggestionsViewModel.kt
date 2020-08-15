package com.jemykeefa.keefamovies.ui.moviedetails.suggestions.suggestions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jemykeefa.keefamovies.data.model.common.Resource
import com.jemykeefa.keefamovies.data.model.model.MoviesListResponse
import com.jemykeefa.keefamovies.data.model.reposirtory.SuggestionsRepository
import com.jemykeefa.keefamovies.utils.Constants
import com.jemykeefa.keefamovies.utils.extensions.addTo
import com.jemykeefa.keefamovies.utils.extensions.setError
import com.jemykeefa.keefamovies.utils.extensions.setLoading
import com.jemykeefa.keefamovies.utils.extensions.setSuccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SuggestionsViewModel (private val popularRepository: SuggestionsRepository) : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    private val _movies = MutableLiveData<Resource<MoviesListResponse>>()

    val movies: LiveData<Resource<MoviesListResponse>>
        get() = _movies

    fun getMovieSuggestions(movieId : Long) {
        popularRepository.getMovieSuggestions(movieId)
            .doOnSubscribe { _movies.setLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ moviesResource ->
                moviesResource?.data?.let { _movies.setSuccess(it) } ?: _movies.setError(
                    moviesResource.message
                )
            }, { throwable ->
                _movies.setError(Constants.Error.GENERAL)
                Log.e("SuggestionFragment", throwable.message ?: "unknown error")
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}