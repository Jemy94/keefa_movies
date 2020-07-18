package com.jemykeefa.keefamovies.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.common.ResourceState.ERROR
import com.jemykeefa.keefamovies.data.model.common.ResourceState.SUCCESS
import com.jemykeefa.keefamovies.data.model.common.ResourceState.LOADING
import com.jemykeefa.keefamovies.di.component.AppComponent
import com.jemykeefa.keefamovies.di.component.DaggerAppComponent
import com.jemykeefa.keefamovies.ui.home.adapter.MovieRecyclerAdapter
import com.jemykeefa.keefamovies.utils.Constants.Error.GENERAL
import com.jemykeefa.keefamovies.utils.extensions.toastLong
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment : Fragment() {


    @Inject
    lateinit var popularViewModelFactory: HomeViewModelFactory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, popularViewModelFactory)
            .get(HomeViewModel::class.java)
    }
    lateinit var component: AppComponent


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
        setupInjection()
        getMovies()
        observeMovies(view)
    }

    private fun setupInjection() {
        component = DaggerAppComponent.builder()
            .build()
        component.inject(this)
    }

    private fun getMovies() {
        viewModel.getMovies()
    }

    private fun observeMovies(view: View) {
        viewModel.movies.observe(viewLifecycleOwner, Observer { resource ->
            when (resource.state) {
                LOADING -> {
                }
                SUCCESS -> {
                    resource.data?.let { moviesResponse ->
                        val adapter = MovieRecyclerAdapter(moviesResponse.data.movies)
                        recyclerView.adapter = adapter
                    }
                }
                ERROR -> {
                    resource.message?.let { msg ->
                        when (msg) {
                            GENERAL -> requireActivity().toastLong(getString(R.string.general_error))
                        }
                    } ?: requireActivity().toastLong(getString(R.string.general_error))
                }
            }
        })
    }
}