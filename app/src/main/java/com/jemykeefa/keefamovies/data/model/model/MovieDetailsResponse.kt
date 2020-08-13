package com.jemykeefa.keefamovies.data.model.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("data")
    @Expose
    val detailsData: DetailsData
) {
    data class DetailsData(

        @SerializedName("movie")
        @Expose
        val movieDetails: MovieDetails
    ) {
        data class MovieDetails(
            val url: String? = "",
            val large_cover_image: String? = "",
            val medium_cover_image: String? = "",
            val title_long: String? = "",
            val description_full: String? = "",
            val description_intro: String? = "",
            val year: Int?,
            val rating: Double?,
            val genres: List<String>? = emptyList(),
            val torrents: List<Torrents>? = emptyList()
        ) {
            data class Torrents(
                    val url: String?,
                    val quality: String?,
                    val size: String?
            )
        }
    }
}
