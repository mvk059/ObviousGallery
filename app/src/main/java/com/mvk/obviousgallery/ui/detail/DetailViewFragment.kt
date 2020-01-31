/*
 * Created by Manpreet Kunnath on 29/1/2020 18:1
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.DetailViewMainBinding
import com.mvk.obviousgallery.ui.detail.adapter.DetailViewAdapter
import com.mvk.obviousgallery.ui.fullscreen.FullScreenFragment
import com.mvk.obviousgallery.ui.main.viewmodel.MainViewModel
import com.mvk.obviousgallery.utils.common.FullScreenClickListener
import com.mvk.obviousgallery.utils.common.addFragment

/**
 * Detail fragment to display all of the information for the selection image
 */
class DetailViewFragment : Fragment(), FullScreenClickListener {

    /**
     * Binding with the layout file (detail_view_main.xml) to access it's elements
     */
    private lateinit var binding: DetailViewMainBinding
    /**
     * View model for the fragment
     */
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_view_main, container, false)
        val view: View = binding.root
        initViewModel()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    override fun onClick(viewPagerPosition: Int) {
        addFragment(
            fragment = FullScreenFragment(),
            container = android.R.id.content,
            addToBackStack = DetailViewFragment::class.java.name
        )
        viewModel.passDataToFullScreenFragment(viewPagerPosition)
    }

    /**
     * Initialize the view model
     */
    private fun initViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            binding.detailVM = viewModel
        }
    }

    /**
     * Initializes the required observers
     */
    private fun initObservers() {
        viewModel.passDataToDetailScreenLD.observe(viewLifecycleOwner, Observer {
            initAdapter(viewModel.imageData)
        })
    }

    /**
     * Setting up the adapter to list the images
     * Navigating to the position of the selected image
     */
    private fun initAdapter(it: ImageData) {
        binding.detailViewPager.adapter = DetailViewAdapter(it, this)
        binding.detailViewPager.currentItem = it.position
    }
}