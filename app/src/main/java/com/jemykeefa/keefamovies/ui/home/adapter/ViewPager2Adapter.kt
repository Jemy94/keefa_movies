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


class ViewPager2Adapter(private val movieList: List<Movie>)  :
    RecyclerView.Adapter<ViewPager2Adapter.ViewPagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager,parent,false)
        return ViewPagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.image.setImageResource(currentItem.small_cover_image!!)
        holder.title.text = movieList[position].title_long
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    class ViewPagerViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView.titleTV
        var image : ImageView = itemView.imageView

    }
}


