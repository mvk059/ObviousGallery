/*
 * Created by Manpreet Kunnath on 29/1/2020 17:14
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.ItemViewDetailBinding


/**
 * View holder to display the images
 *
 * @param binding Binding with the layout file (detail_view_item.xml) to access it's elements
 */
class DetailViewHolder(var binding: ItemViewDetailBinding) : RecyclerView.ViewHolder(binding.root) {

    /**
     * Sets all the required information in their respective fields
     *
     * @param imageData Array of images
     * @param position Position of the current item in the view pager
     */
    fun bindItems(imageData: ImageData, position: Int) {
        Glide.with(itemView)
            .load(imageData.image[position].url)
            .transform(CenterCrop())
            .placeholder(R.drawable.ic_placeholder)
            .error(R.drawable.ic_error)
            .fallback(R.drawable.ic_error)
            .into(binding.detailMainIV)

        binding.detailTitleTV.text = imageData.image[position].title
        val copyright = String.format(
            binding.detailCopyrightTV.context.resources.getString(R.string.detail_text_copyright),
            imageData.image[position].copyright
        )
        binding.detailCopyrightTV.text = copyright
        binding.detailExplanationTV.text = imageData.image[position].explanation
        binding.detailDateTV.text = imageData.image[position].date

    }

}