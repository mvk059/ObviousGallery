/*
 * Created by Manpreet Kunnath on 29/1/2020 17:14
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.ItemViewDetailBinding
import com.mvk.obviousgallery.utils.common.FullScreenClickListener

/**
 * Recycler view adapter for the main screen listing.
 *
 * @param imageData List of images to display in the fragment
 */
class DetailViewAdapter(
    var imageData: ImageData,
    var fullScreenClickListener: FullScreenClickListener
) : RecyclerView.Adapter<DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewDetailBinding.inflate(inflater, parent, false)
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int = imageData.image.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bindItems(imageData, position, fullScreenClickListener)
    }
}