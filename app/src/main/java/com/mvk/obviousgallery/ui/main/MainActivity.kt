/*
 * Created by Manpreet Kunnath on 29/1/2020 15:26
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.ActivityMainBinding
import com.mvk.obviousgallery.ui.detail.DetailViewFragment
import com.mvk.obviousgallery.ui.main.adapter.MainGalleryAdapter
import com.mvk.obviousgallery.ui.main.viewmodel.MainViewModel
import com.mvk.obviousgallery.utils.common.Constants
import com.mvk.obviousgallery.utils.common.ImageClickListener
import com.mvk.obviousgallery.utils.common.addFragment


class MainActivity : AppCompatActivity(), ImageClickListener {

    /**
     * Binding with the layout file (activity_main.xml) to access it's elements
     */
    private lateinit var binding: ActivityMainBinding
    /**
     * View model for the activity
     */
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewModel()
        setAdapter()
    }

    /**
     * Implementation of ImageClickListener
     * On click of an image in the main screen, navigates to the detail screen
     * while passing data through the view model
     */
    override fun onClick(imageData: ImageData) {
        addFragment(
            fragment = DetailViewFragment(),
            container = android.R.id.content,
            addToBackStack = MainActivity::class.java.name
        )
        viewModel.passDataToDetailFragment(imageData = imageData)
    }

    /**
     * Initialize the view model
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainVM = viewModel
    }

    /**
     * Setting up the adapter to list the images
     */
    private fun setAdapter() {
        val array = viewModel.getData()
        val galleryAdapter = MainGalleryAdapter(
            imageList = array,
            imageClickListener = this,
            repository = viewModel.repository)
        binding.rvMain.apply {
            layoutManager = GridLayoutManager(context, Constants.GRID_SIZE)
            adapter = galleryAdapter
        }
    }

}
