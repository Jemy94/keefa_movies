package com.jemykeefa.keefamovies.data.model.remote

import com.jemykeefa.keefamovies.data.model.model.MoviesListResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET(Endpoints.MOVIES_LIST) fun getMoviesList() : Single<Response<MoviesListResponse>>
}