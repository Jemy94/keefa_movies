package com.jemykeefa.keefamovies.data.model

data class Movie(
   val title : String?,
   val small_cover_image : Int?,
   val rating : Double?,
   val title_long : String?,
   val year : Int?,
   val url : String?,
   val  runtime : Long?,
   val genres : List<String>?,
   val torrents : List<Torrents>
)