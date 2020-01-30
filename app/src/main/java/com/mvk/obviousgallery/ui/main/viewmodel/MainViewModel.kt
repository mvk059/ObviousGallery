/*
 * Created by Manpreet Kunnath on 29/1/2020 10:52
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mvk.obviousgallery.data.datasource.GalleryDataSource
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.data.model.ImageData

/**
 * View model for MainActivity and DetailViewFragment
 */
class MainViewModel(var app: Application) : AndroidViewModel(app) {

    /**
     * Stores the image data read from the JSON file
     */
    lateinit var imageData: ImageData
    /**
     * Live data to communicate between activity and fragment
     */
    val passDataLiveData = MutableLiveData<Boolean>()

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
     * Pass data from activity to fragment
     *
     * @param imageData Array of images
     */
    fun passDataToFragment(imageData: ImageData) {
        this.imageData = imageData
        passDataLiveData.value = true
    }
}