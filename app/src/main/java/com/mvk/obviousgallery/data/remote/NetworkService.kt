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
import com.mvk.obviousgallery.utils.common.Constants
import com.mvk.obviousgallery.utils.display.Toaster

/**
 * Repository layer to make network calls
 */
object NetworkService {

    /**
     * Calls Glide service to load URL to an ImageView
     *
     * @param context Context of the detail screen fragment
     * @param url URL to call
     * @param sourceType Source of the screen calling the method
     * @param target Target ImageView to place the image
     * @param fullScreenIV ImageView of the full screen button in detail fragment
     * @param placeholderImage Image resource for the placeholder
     * @param errorImage Image resource for when the downloading of the URL fails
     *
     */
    fun callGlideService(
        context: Context,
        url: String,
        sourceType: Int,
        target: ImageView,
        fullScreenIV: ImageView = ImageView(context),
        placeholderImage: Int = R.drawable.ic_placeholder,
        errorImage: Int = R.drawable.ic_error
    ) {
        val crop =
            if (sourceType == Constants.SOURCE_FULL_SCREEN ) FitCenter()
            else CenterCrop()
        // Load images with Glide
        Glide.with(context)
            .load(url)
            .transform(crop)
            .placeholder(placeholderImage)
            .error(errorImage)
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
                    if (sourceType == Constants.SOURCE_DETAIL_SCREEN)
                        fullScreenIV.visibility = View.VISIBLE
                    return false
                }

            })
            .into(target)
    }
}