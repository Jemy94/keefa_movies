package com.jemykeefa.keefamovies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.ui.home.adapter.MovieRecyclerAdapter


class HomeFragment : Fragment() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: MovieRecyclerAdapter

    //this is just for assign xml layout to the fragment
    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    //this is similar to onCreate in Activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}