/*
 * Created by Manpreet Kunnath on 29/1/2020 10:52
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main.viewmodel

import android.app.Application
import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mvk.obviousgallery.data.datasource.GalleryDataSource
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.data.remote.NetworkService

/**
 * View model for MainActivity and DetailViewFragment
 */
class MainViewModel(var app: Application) : AndroidViewModel(app) {
    /**
     * Position of the view pager of the detail screen
     */
    private var viewPagerPosition: Int = 0
    /**
     * Stores the image data read from the JSON file
     */
    lateinit var imageData: ImageData
    /**
     * Live data to communicate between main activity and detail fragment
     */
    val passDataToDetailScreenLD = MutableLiveData<Boolean>()
    /**
     * Live data to communicate between detail fragment and full screen fragment
     */
    val passDataToFullScreenLD = MutableLiveData<Boolean>()

    /**
     * Gets the data from the data source
     *
     * @return Array of images
     */
    fun getData(): Array<Image>? {
        val dataSource = GalleryDataSource(app)
        return dataSource.getImageData()
    }

    /**
     * Pass data from main activity to detail fragment
     *
     * @param imageData Array of images
     */
    fun passDataToDetailFragment(imageData: ImageData) {
        this.imageData = imageData
        passDataToDetailScreenLD.value = true
    }

    /**
     * Pass data from detail fragment to full screen fragment
     */
    fun passDataToFullScreenFragment(
        viewPagerPosition: Int
    ) {
        this.viewPagerPosition = viewPagerPosition
        passDataToFullScreenLD.value = true
    }

    /**
     * Call the HD url on clicking on full screen icon
     *
     * @param context Context of the full screen fragment
     * @param fullIV Image view of the downloaded image
     */
    fun setFullScreenImage(context: Context, fullIV: ImageView) {
        NetworkService.fetchFullScreenImage(
            context = context,
            fullScreenIV = fullIV,
            imageData = imageData,
            viewPagerPosition = viewPagerPosition
        )
    }
}