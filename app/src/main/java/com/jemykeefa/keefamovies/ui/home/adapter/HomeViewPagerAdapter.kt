package com.jemykeefa.keefamovies.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.model.Movie
import com.jemykeefa.keefamovies.utils.extensions.load
import kotlinx.android.synthetic.main.item_viewpager.view.*


class HomeViewPagerAdapter(private val movieList: List<Movie>)  :
    RecyclerView.Adapter<HomeViewPagerAdapter.ViewPagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager,parent,false)
        return ViewPagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.title.text = currentItem.title_long
        currentItem.large_cover_image?.let { holder.image.load(it) }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    class ViewPagerViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView.viewPagerTextView
        var image : ImageView = itemView.viewPagerImageView

    }
}


