package com.jemykeefa.keefamovies.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jemykeefa.keefamovies.ui.home.adapter.MovieRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var layoutManager: GridLayoutManager
    lateinit var adapter: MovieRecyclerAdapter

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

}