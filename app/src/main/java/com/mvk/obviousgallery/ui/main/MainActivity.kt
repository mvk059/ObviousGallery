/*
 * Created by Manpreet Kunnath on 29/1/2020 15:26
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.ActivityMainBinding
import com.mvk.obviousgallery.ui.detail.DetailViewFragment
import com.mvk.obviousgallery.ui.main.adapter.MainGalleryAdapter
import com.mvk.obviousgallery.ui.main.viewmodel.MainViewModel
import com.mvk.obviousgallery.utils.common.ImageClickListener


class MainActivity : AppCompatActivity(), ImageClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    // A bare bones implementation of the recycler view. Will change later
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainVM = viewModel

        setAdapter()

        viewModel.passDataLiveData.observe(this, Observer {  })
    }

    override fun onClick(imageData: ImageData) {
        supportFragmentManager
            .beginTransaction()
            .add(
                android.R.id.content,
                DetailViewFragment.newInstance(),
                DetailViewFragment::class.java.name
            )
            .addToBackStack(MainActivity::class.java.name)
            .commit()
        viewModel.passDataToFragment(imageData)
    }

    private fun setAdapter() {
        val array = viewModel.getData()
        val galleryAdapter = MainGalleryAdapter(array, this)
        binding.rvMain.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = galleryAdapter
        }
    }

}
