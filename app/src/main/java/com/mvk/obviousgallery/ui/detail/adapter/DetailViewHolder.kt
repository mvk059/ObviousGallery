/*
 * Created by Manpreet Kunnath on 29/1/2020 17:14
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.DetailViewItemBinding

/**
 * View holder to display the images
 *
 * @param binding Binding with the layout file (detail_view_item.xml) to access it's elements
 */
class DetailViewHolder(var binding: DetailViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItems(imageData: ImageData, position: Int) {
        binding.detailTV.text = imageData.image[position].date
    }

}