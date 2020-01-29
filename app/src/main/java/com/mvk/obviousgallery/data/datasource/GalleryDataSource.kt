/*
 * Created by Manpreet Kunnath on 28/1/2020 17:17
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.data.datasource

import android.content.Context
import com.google.gson.GsonBuilder
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.utils.common.readInput
import com.mvk.obviousgallery.utils.display.Toaster
import java.io.IOException


/**
 * Class to manipulate and restructure the data
 */
class GalleryDataSource(var context: Context) {

    /**
     * Fetches the JSON file from the assets directory and maps it to the model
     *
     * @return Image model
     */
    fun getImageData(): Array<Image>? {
        var json: String? = ""
        try {
            val inputStream = context.assets.open("data1.json")
            json = inputStream.readInput()
        } catch (e: IOException) {
            Toaster.show(context, context.getString(R.string.error_text_file_not_found))
        }
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.fromJson(json, Array<Image>::class.java)
    }
}