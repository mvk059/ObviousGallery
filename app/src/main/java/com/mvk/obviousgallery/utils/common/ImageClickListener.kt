/*
 * Created by Manpreet Kunnath on 29/1/2020 11:1
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.utils.common

import com.mvk.obviousgallery.data.model.ImageData

/**
 * Interface to handle clicks of images
 */
interface ImageClickListener {

    fun onClick(imageData: ImageData)
}