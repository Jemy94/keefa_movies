package com.jemykeefa.keefamovies.ui.moviedetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jemykeefa.keefamovies.R
import com.jemykeefa.keefamovies.ui.moviedetails.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_tablayout.*
import java.util.*


class TabLayoutFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?= inflater.inflate(R.layout.fragment_tablayout, container, false)
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val adapter = CategoryAdapter(requireActivity(),requireActivity().supportFragmentManager)
    viewpager.adapter =adapter
    tabs.setupWithViewPager(viewpager)
    Log.d("tab fragment","tab on creat")


    }

  override fun onStart() {
    super.onStart()
    Log.d("tab fragment","on start")

  }

  override fun onResume() {
    super.onResume()
    Log.d("tab fragment","on resume")

  }


}