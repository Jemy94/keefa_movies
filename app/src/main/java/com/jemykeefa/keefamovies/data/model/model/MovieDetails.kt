package com.jemykeefa.keefamovies.data.model.model

class MovieDetails (
    val id : String?,
    val url : String? = "",
    val large_cover_image: String? = "",
    val medium_cover_image: String? = "",
    val title_long: String? = "",
    val description_full: String? = "",
    val description_intro: String? = "",
    val year: Int?,
    val rating: Double?,
    val genres: List<String>? = emptyList(),
    val torrents: List<Torrents>? = emptyList()
    )