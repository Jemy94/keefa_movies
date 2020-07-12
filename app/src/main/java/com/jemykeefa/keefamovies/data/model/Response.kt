package com.jemykeefa.keefamovies.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response (
    @SerializedName("data")
    @Expose
    val data : Data
)