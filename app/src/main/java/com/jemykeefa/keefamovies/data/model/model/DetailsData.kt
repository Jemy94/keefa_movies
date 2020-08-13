package com.jemykeefa.keefamovies.data.model.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailsData(

    @SerializedName("movie")
    @Expose
    val movieDetails: MovieDetails
)