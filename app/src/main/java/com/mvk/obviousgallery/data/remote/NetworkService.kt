/*
 * Created by Manpreet Kunnath on 31/1/2020 12:57
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.data.remote

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.utils.display.Toaster

/**
 * Class to make network calls
 */
object NetworkService {

    /**
     * Fetch the HD url from Glide
     *
     * @param context Context of the full screen fragment
     * @param fullScreenIV Image view of the downloaded image
     * @param imageData Array of images
     * @param viewPagerPosition Position of the view pager to fetch the image at that position
     */
    fun fetchFullScreenImage(
        context: Context,
        fullScreenIV: ImageView,
        imageData: ImageData,
        viewPagerPosition: Int
    ) {
        // Load images with Glide
        Glide.with(context)
            .load(imageData.image[viewPagerPosition].hdurl)
            .transform(FitCenter())
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .fallback(R.drawable.ic_error)
            .listener(object : RequestListener<Drawable> {
                // If image loading fails show the error
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toaster.show(context, "Failed to load image. Please retry")
                    return false
                }

                // When the image is loaded show the full screen icon
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean = false
            })
            .into(fullScreenIV)
    }

    fun fetchDetailScreenImage(
        context: Context,
        itemView: View,
        imageData: ImageData,
        viewPagerPosition: Int,
        detailFullScreenIV: ImageView,
        detailMainIV: ImageView
    ) {
        // Load images with Glide
        Glide.with(itemView)
            .load(imageData.image[viewPagerPosition].url)
            .transform(CenterCrop())
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .fallback(R.drawable.ic_error)
            .listener(object : RequestListener<Drawable> {
                // If image loading fails show the error
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Toaster.show(context, "Failed to load image. Please retry")
                    return false
                }

                // When the image is loaded show the full screen icon
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    detailFullScreenIV.visibility = View.VISIBLE
                    return false
                }

            })
            .into(detailMainIV)

    }
}