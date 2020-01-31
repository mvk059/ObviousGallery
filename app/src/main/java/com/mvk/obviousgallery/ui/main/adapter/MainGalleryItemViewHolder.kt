/*
 * Created by Manpreet Kunnath on 29/1/2020 11:2
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.data.repository.NetworkRepository
import com.mvk.obviousgallery.databinding.ItemViewHomeMainBinding
import com.mvk.obviousgallery.utils.common.ImageClickListener

/**
 * View holder to display the images
 *
 * @param binding Binding with the layout file (item_view_home_main.xml) to access it's elements
 */
class MainGalleryItemViewHolder(var binding: ItemViewHomeMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Loads the images through Glide and handles click of each item
     *
     * @param images List of images to show
     * @param position Position of the current loading image
     * @param imageClickListener Listener to handle clicks on each button
     * @param repository Repository layer to make the network calls
     */
    fun bindItems(
        images: Array<Image>,
        position: Int,
        imageClickListener: ImageClickListener,
        repository: NetworkRepository
    ) {

        repository.fetchMainScreenImage(
            context = binding.rvItemHomeMain.context,
            imageData = ImageData(images, position),
            viewPagerPosition = position,
            targetIV = binding.rvItemHomeMain
        )

        binding.rvItemHomeMain.setOnClickListener {
            imageClickListener.onClick(ImageData(images, position))
        }
    }
}