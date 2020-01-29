/*
 * Created by Manpreet Kunnath on 28/1/2020 17:24
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.datasource.GalleryDataSource
import com.mvk.obviousgallery.databinding.ActivityMainBinding
import com.mvk.obviousgallery.ui.adapter.MainGalleryAdapter
import com.mvk.obviousgallery.utils.common.ImageClickListener
import com.mvk.obviousgallery.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), ImageClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    // A bare bones implementation of the recycler view. Will change later
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainVM = viewModel

        val dataSource = GalleryDataSource(this)
        val array = dataSource.getImageData()
        val galleryAdapter = MainGalleryAdapter(this, array, this)
        binding.rvMain.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = galleryAdapter
        }
    }

    override fun onClick() {

    }
}
