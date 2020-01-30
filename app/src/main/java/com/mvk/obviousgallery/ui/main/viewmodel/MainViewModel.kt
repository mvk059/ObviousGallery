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
 * // A bare bones implementation of the view model. Will change later
 */
class MainViewModel(var app: Application) : AndroidViewModel(app) {

    lateinit var imageData: ImageData
    val passDataLiveData = MutableLiveData<Boolean>()

    fun getData(): Array<Image>? {
        val dataSource = GalleryDataSource(app)
        return dataSource.getImageData()
    }

    fun passDataToFragment(imageData: ImageData) {
        this.imageData = imageData
        passDataLiveData.value = true
    }
}