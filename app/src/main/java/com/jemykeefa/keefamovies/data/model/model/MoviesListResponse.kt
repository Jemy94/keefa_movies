package com.jemykeefa.keefamovies.data.model.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.jemykeefa.keefamovies.data.model.model.Data

class MoviesListResponse (
    @SerializedName("data")
    @Expose
    val data : Data
)