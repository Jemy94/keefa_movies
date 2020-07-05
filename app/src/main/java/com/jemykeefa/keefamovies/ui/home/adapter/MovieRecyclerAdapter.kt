package com.jemykeefa.keefamovies.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieRecyclerAdapter(private val movieList: List<Movie>)  : RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text = movieList[position].title_long
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    class MovieViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var title : TextView = itemView.titleTV
        var image : ImageView = itemView.imageView

    }
}