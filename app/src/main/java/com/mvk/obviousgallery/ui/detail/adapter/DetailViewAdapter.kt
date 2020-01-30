/*
 * Created by Manpreet Kunnath on 29/1/2020 17:14
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.DetailViewItemBinding

/**
 * Recycler view adapter for the main screen listing.
 *
 * @param imageData List of images to display in the fragment
 */
class DetailViewAdapter(
    var imageData: ImageData
) : RecyclerView.Adapter<DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DetailViewItemBinding.inflate(inflater, parent, false)
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int = imageData.image.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bindItems(imageData, position)
    }
}