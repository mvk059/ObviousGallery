/*
 * Created by Manpreet Kunnath on 31/1/2020 13:41
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.data.repository

import android.content.Context
import android.widget.ImageView
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.data.remote.NetworkService
import com.mvk.obviousgallery.utils.common.Constants

/**
 * Repository layer responsible to call the NetworkService
 */
class NetworkRepository {

    /**
     * Call the method to fetch the HD url from Glide
     *
     * @param context Context of the MainActivity
     * @param imageData Array of images
     * @param viewPagerPosition Position of the view pager to fetch the image at that position
     * @param targetIV Target ImageView to place the image
     */
    fun fetchMainScreenImage(
        context: Context,
        imageData: ImageData,
        viewPagerPosition: Int,
        targetIV: ImageView
    ) {

        NetworkService.callGlideService(
            context = context,
            url = imageData.image[viewPagerPosition].url,
            sourceType = Constants.SOURCE_MAIN_SCREEN,
            target = targetIV
        )
    }

    /**
     * Call the method to fetch the HD url from Glide
     *
     * @param context Context of the detail screen fragment
     * @param imageData Array of images
     * @param viewPagerPosition Position of the view pager to fetch the image at that position
     * @param detailFullScreenIV Image view of the full screen image icon
     * @param targetIV Target ImageView to place the image
     */
    fun fetchDetailScreenImage(
        context: Context,
        imageData: ImageData,
        viewPagerPosition: Int,
        detailFullScreenIV: ImageView,
        targetIV: ImageView
    ) {

        NetworkService.callGlideService(
            context = context,
            url = imageData.image[viewPagerPosition].url,
            sourceType = Constants.SOURCE_DETAIL_SCREEN,
            target = targetIV,
            fullScreenIV = detailFullScreenIV

        )
    }

    /**
     * Call the method to fetch the HD url from Glide
     *
     * @param context Context of the full screen fragment
     * @param imageData Array of images
     * @param viewPagerPosition Position of the view pager to fetch the image at that position
     * @param fullScreenIV Target ImageView to place the image
     */
    fun fetchFullScreenImage(
        context: Context,
        imageData: ImageData,
        viewPagerPosition: Int,
        fullScreenIV: ImageView
    ) {

        NetworkService.callGlideService(
            context = context,
            url = imageData.image[viewPagerPosition].url,
            sourceType = Constants.SOURCE_FULL_SCREEN,
            target = fullScreenIV
        )
    }
}