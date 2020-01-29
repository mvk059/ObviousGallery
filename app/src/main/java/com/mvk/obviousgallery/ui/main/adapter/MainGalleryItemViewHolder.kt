/*
 * Created by Manpreet Kunnath on 29/1/2020 11:2
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.databinding.ItemViewHomeMainBinding
import com.mvk.obviousgallery.utils.common.ImageClickListener

// A bare bones implementation of the recycler view holder. Will change later
class MainGalleryItemViewHolder(var binding: ItemViewHomeMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Loads the images through Glide and handles click of each item
     *
     * @param images List of images to show
     * @param position Position of the current loading image
     * @param imageClickListener Listener to handle clicks on each button
     */
    fun bindItems(
        images: Array<Image>,
        position: Int,
        imageClickListener: ImageClickListener
    ) {

        Glide.with(itemView)
            .load(images[position])
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .fallback(R.drawable.placeholder)
            .into(binding.rvItemHomeMain)

        imageClickListener.onClick(images, position)
    }
}