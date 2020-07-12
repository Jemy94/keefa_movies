package com.jemykeefa.keefamovies.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("movies")
    @Expose
    val movies : List<Movie>
)