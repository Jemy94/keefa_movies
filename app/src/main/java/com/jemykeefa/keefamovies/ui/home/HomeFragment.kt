package com.jemykeefa.keefamovies.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.common.ResourceState.ERROR
import com.jemykeefa.keefamovies.data.model.common.ResourceState.SUCCESS
import com.jemykeefa.keefamovies.data.model.common.ResourceState.LOADING
import com.jemykeefa.keefamovies.data.model.model.Movie
import com.jemykeefa.keefamovies.di.component.AppComponent
import com.jemykeefa.keefamovies.di.component.DaggerAppComponent
import com.jemykeefa.keefamovies.ui.home.adapter.HomeRecyclerAdapter
import com.jemykeefa.keefamovies.ui.home.adapter.HomeViewPagerAdapter
import com.jemykeefa.keefamovies.utils.Constants
import com.jemykeefa.keefamovies.utils.Constants.Error.GENERAL
import com.jemykeefa.keefamovies.utils.extensions.toastLong
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject



class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, homeViewModelFactory)
            .get(HomeViewModel::class.java)
    }
    //dagger code
    lateinit var component: AppComponent

    private val sharedPreferences by lazy {  requireActivity().getSharedPreferences(Constants.SHARED_PREFERENCE,
        Context.MODE_PRIVATE)}


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

    //dagger code
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
                        val adapter = HomeRecyclerAdapter(moviesResponse.data.movies)
                        recyclerView.adapter = adapter
                        val viewPagerList = mutableListOf<Movie>()
                        for (index in 5..9){
                            viewPagerList.add(moviesResponse.data.movies[index])

                        }
                        val viewPagerAdapter = HomeViewPagerAdapter(viewPagerList)
                        viewPager.adapter = viewPagerAdapter
                        pageIndicatorView.count = viewPagerList.size
                        pageIndicatorView.selection = viewPager.currentItem

                        adapter.setItemCallBack {movie ->

                            val editor =  sharedPreferences.edit()
                            movie?.id?.let { editor.putLong(Constants.MOVIE_ID, it).commit() }
                            view.findNavController().navigate(R.id.action_homeFragment_to_tabLayoutFragment)

                        }

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