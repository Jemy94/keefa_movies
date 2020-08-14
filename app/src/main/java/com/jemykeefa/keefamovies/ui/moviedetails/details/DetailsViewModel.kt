package com.jemykeefa.keefamovies.ui.moviedetails.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jemykeefa.keefamovies.data.model.common.Resource
import com.jemykeefa.keefamovies.data.model.model.MovieDetailsResponse
import com.jemykeefa.keefamovies.data.model.reposirtory.DetailsRepository
import com.jemykeefa.keefamovies.utils.Constants
import com.jemykeefa.keefamovies.utils.extensions.addTo
import com.jemykeefa.keefamovies.utils.extensions.setError
import com.jemykeefa.keefamovies.utils.extensions.setLoading
import com.jemykeefa.keefamovies.utils.extensions.setSuccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailsViewModel (private val popularRepository: DetailsRepository) : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    private val _movieDetails = MutableLiveData<Resource<MovieDetailsResponse>>()

    val movies: LiveData<Resource<MovieDetailsResponse>>
        get() = _movieDetails

    fun getMovieDetils(movieId : Long) {
        popularRepository.getDetails(movieId)
            .doOnSubscribe { _movieDetails.setLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ moviesResource ->
                moviesResource?.data?.let { _movieDetails.setSuccess(it) } ?: _movieDetails.setError(
                    moviesResource.message
                )
            }, { throwable ->
                _movieDetails.setError(Constants.Error.GENERAL)
                Log.e("DetailsFragment", throwable.message ?: "unknown error")
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}