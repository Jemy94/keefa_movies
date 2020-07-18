package com.jemykeefa.keefamovies.data.model.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status_code")
    @Expose
    val statusCode: Int,
    @SerializedName("status_message")
    @Expose
    val statusMessage: String? = "",
    @SerializedName("success")
    @Expose
    val success: Boolean? = false
)