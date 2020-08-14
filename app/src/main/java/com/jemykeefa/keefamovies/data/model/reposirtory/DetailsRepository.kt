package com.jemykeefa.keefamovies.data.model.reposirtory

import com.jemykeefa.keefamovies.data.model.common.Resource
import com.jemykeefa.keefamovies.data.model.common.Validator
import com.jemykeefa.keefamovies.data.model.model.MovieDetailsResponse
import com.jemykeefa.keefamovies.data.model.remote.ApiInterface
import io.reactivex.Single
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val validator: Validator
) {

    fun getDetails(movieId : Long): Single<Resource<MovieDetailsResponse>> {
        return apiInterface.getMovieDetails(movieId)
            .map { validator.validateResponse(it) }
            .map { Resource(it.state, if (it.data == null) null else it.data, it.message) }
    }
}