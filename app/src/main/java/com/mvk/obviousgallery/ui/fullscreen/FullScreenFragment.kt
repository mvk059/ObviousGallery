/*
 * Created by Manpreet Kunnath on 30/1/2020 18:2
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.databinding.FullScreenViewMainBinding
import com.mvk.obviousgallery.ui.main.viewmodel.MainViewModel

/**
 * Full Screen fragment to display the HD version of the selected image
 */
class FullScreenFragment : Fragment() {

    /**
     * Binding with the layout file (full_screen_view_main.xml) to access it's elements
     */
    private lateinit var binding: FullScreenViewMainBinding
    /**
     * View model for the fragment
     */
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.full_screen_view_main, container, false)
        val view: View = binding.root
        initViewModel()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    /**
     * Initialize the view model
     */
    private fun initViewModel() {
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)
            binding.fullScreenVM = viewModel
        }
    }

    /**
     * Initializes the required observers
     */
    private fun initObservers() {
        viewModel.passDataToFullScreenLD.observe(viewLifecycleOwner, Observer {
            context?.let {
                viewModel.setFullScreenImage(it, binding.fullIV)
                activity?.window?.decorView?.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LOW_PROFILE or
                            View.SYSTEM_UI_FLAG_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            }
        })
    }
}