package com.jemykeefa.keefamovies.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.model.Movie
import com.jemykeefa.keefamovies.utils.Constants
import com.jemykeefa.keefamovies.utils.extensions.listen
import com.jemykeefa.keefamovies.utils.extensions.load
import kotlinx.android.synthetic.main.item_movie.view.*

class HomeRecyclerAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<HomeRecyclerAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView).listen {position, type ->
            val item = movieList.get(position)

        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        currentItem.medium_cover_image?.let { holder.image.load(it) }
        holder.title.text = currentItem.title
        holder.rating.text = currentItem.rating.toString()
        holder.year.text = currentItem.year.toString()


    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.titleTV
        var rating: TextView = itemView.ratingTV
        var year: TextView = itemView.yearTV
        var image: ImageView = itemView.imageView

    }

}