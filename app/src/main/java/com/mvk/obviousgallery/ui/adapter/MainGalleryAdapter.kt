/*
 * Created by Manpreet Kunnath on 29/1/2020 11:0
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.databinding.ItemViewHomeMainBinding
import com.mvk.obviousgallery.utils.common.ImageClickListener

/**
 * Recycler view adapter for the main screen listing.
 * A bare bones implementation of the recycler view adapter. Will change later
 *
 * @param context Context of the activity it is called from
 * @param imageList List of images to display in the activity
 * @param imageClickListener Listener to handle clicks of the images
 */
class MainGalleryAdapter(
    var context: Context,
    var imageList: Array<Image>?,
    var imageClickListener: ImageClickListener
) : RecyclerView.Adapter<MainGalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainGalleryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewHomeMainBinding.inflate(inflater, parent, false)
        return MainGalleryViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList?.size ?: 0

    override fun onBindViewHolder(holder: MainGalleryViewHolder, position: Int) {
        imageList?.let {
            if (it.isNotEmpty()) {
                holder.bindItems(context, it[position])
            }
        }
    }
}