/*
 * Created by Manpreet Kunnath on 29/1/2020 11:0
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.databinding.ItemViewHomeMainBinding
import com.mvk.obviousgallery.utils.common.ImageClickListener

/**
 * Recycler view adapter for the main screen listing.
 *
 * @param imageList List of images to display in the activity
 * @param imageClickListener Listener to handle clicks of the images
 */
class MainGalleryAdapter(
    var imageList: Array<Image>?,
    var imageClickListener: ImageClickListener
) : RecyclerView.Adapter<MainGalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainGalleryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewHomeMainBinding.inflate(inflater, parent, false)
        return MainGalleryItemViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList?.size ?: 0

    override fun onBindViewHolder(holder: MainGalleryItemViewHolder, position: Int) {
        imageList?.let {
            if (it.isNotEmpty()) {
                holder.bindItems(it, position, imageClickListener)
            }
        }
    }
}