package com.jemykeefa.keefamovies.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("movies")
    @Expose
    val movieList : List<Movie>
)