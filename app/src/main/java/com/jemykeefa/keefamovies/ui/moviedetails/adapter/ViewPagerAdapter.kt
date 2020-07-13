package com.jemykeefa.keefamovies.ui.moviedetails.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jemykeefa.keefamovies.ui.moviedetails.details.DetailsFragment
import com.jemykeefa.keefamovies.ui.moviedetails.suggestions.SuggestionsFragment

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
  private val detailsFragment = DetailsFragment()
   private val suggestionsFragment = SuggestionsFragment()
    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> detailsFragment
            1 -> suggestionsFragment
            else -> detailsFragment

        }
}

    override fun getCount(): Int {
       return 2
    }
}