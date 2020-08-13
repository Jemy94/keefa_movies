package com.jemykeefa.keefamovies.data.model.model

data class Movie(
    val id: Int?,
    val title: String?,
    val large_cover_image: String? = "",
    val medium_cover_image: String? = "",
    val rating: Double?,
    val title_long: String? = "",
    val year: Int?,
    val url: String? = "",
    val runtime: Long?

)