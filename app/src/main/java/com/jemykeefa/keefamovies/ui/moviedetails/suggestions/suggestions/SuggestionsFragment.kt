package com.jemykeefa.keefamovies.ui.moviedetails.suggestions.suggestions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.data.model.common.ResourceState
import com.jemykeefa.keefamovies.di.component.AppComponent
import com.jemykeefa.keefamovies.di.component.DaggerAppComponent
import com.jemykeefa.keefamovies.ui.moviedetails.suggestions.adapter.SuggestionsRecyclerAdapter
import com.jemykeefa.keefamovies.utils.Constants
import com.jemykeefa.keefamovies.utils.extensions.toastLong
import kotlinx.android.synthetic.main.fragment_suggestions.*
import javax.inject.Inject

class SuggestionsFragment : Fragment() {

    @Inject
    lateinit var suggestionsViewModelFactory: SuggestionsViewModelFactory
    private val viewModel: SuggestionsViewModel by lazy {
        ViewModelProvider(this, suggestionsViewModelFactory)
            .get(SuggestionsViewModel::class.java)
    }

    //dagger code
    lateinit var component: AppComponent


    //this is just for assign xml layout to the fragment
    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_suggestions, container, false)

    //this is similar to onCreate in Activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInjection()
        getMovies()
        observeSuggestionsMovies(view)
    }

    //dagger code
    private fun setupInjection() {
        component = DaggerAppComponent.builder()
            .build()
        component.inject(this)
    }

    private fun getMovies() {
        viewModel.getMovieSuggestions()
    }

    private fun observeSuggestionsMovies(view: View) {
        viewModel.movies.observe(viewLifecycleOwner, Observer { resource ->
            when (resource.state) {
                ResourceState.LOADING -> {
                }
                ResourceState.SUCCESS -> {
                    resource.data?.let { suggestionsMovie ->
//                        val adapter = SuggestionsRecyclerAdapter(suggestionsMovie.data.movies)
//                        suggestionGridView.adapter = adapter

                    }
                }
                ResourceState.ERROR -> {
                    resource.message?.let { msg ->
                        when (msg) {
                            Constants.Error.GENERAL -> requireActivity().toastLong(getString(R.string.general_error))
                        }
                    } ?: requireActivity().toastLong(getString(R.string.general_error))
                }
            }
        })
    }
}
