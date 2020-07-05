package com.jemykeefa.keefamovies.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MainObject (
    @SerializedName("data")
    @Expose
    val movies : Movies
)