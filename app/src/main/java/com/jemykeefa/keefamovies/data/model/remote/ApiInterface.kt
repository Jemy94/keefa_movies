package com.jemykeefa.keefamovies.data.model.remote

import com.jemykeefa.keefamovies.data.model.model.MovieDetailsResponse
import com.jemykeefa.keefamovies.data.model.model.MoviesListResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET(Endpoints.MOVIES_LIST) fun getMoviesList() : Single<Response<MoviesListResponse>>
    @GET(Endpoints.MOVIE_DETAILS) fun getMovieDetails() : Single<Response<MovieDetailsResponse>>
    @GET(Endpoints.MOVIE_SUGGESTIONS) fun getMovieSuggestions () : Single<Response<MoviesListResponse>>
}