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

    private var itemCallback: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView, itemCallback)
    }


    fun setItemCallBack(itemCallback: (Movie?) -> Unit) {
        this.itemCallback = itemCallback
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.bind(currentItem)

    }

    override fun getItemCount(): Int = movieList.size


    class MovieViewHolder(itemView: View, private val itemCallback: ((Movie) -> Unit)?) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.titleTV
        var rating: TextView = itemView.ratingTV
        var year: TextView = itemView.yearTV
        var image: ImageView = itemView.imageView
        fun bind(movie: Movie) {
            itemView.setOnClickListener { itemCallback?.invoke(movie) }
            title.text = movie.title
            rating.text = movie.rating.toString()
            movie.medium_cover_image?.let { image.load(it) }
            year.text = movie.year.toString()
        }

    }
}


