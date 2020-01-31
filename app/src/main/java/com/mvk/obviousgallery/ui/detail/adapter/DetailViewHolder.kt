/*
 * Created by Manpreet Kunnath on 29/1/2020 17:14
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.data.remote.NetworkService
import com.mvk.obviousgallery.databinding.ItemViewDetailBinding
import com.mvk.obviousgallery.utils.common.FullScreenClickListener


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
     * @param viewPagerPosition Position of the current item in the view pager
     */
    fun bindItems(
        imageData: ImageData,
        viewPagerPosition: Int,
        fullScreenClickListener: FullScreenClickListener
    ) {

        NetworkService.fetchDetailScreenImage(
            context = binding.detailTitleTV.context,
            itemView = itemView,
            imageData = imageData,
            viewPagerPosition = viewPagerPosition,
            detailFullScreenIV = binding.detailFullScreenIV,
            detailMainIV = binding.detailMainIV
        )
        binding.detailTitleTV.text = imageData.image[viewPagerPosition].title
        val copyright = String.format(
            binding.detailCopyrightTV.context.resources.getString(R.string.detail_text_copyright),
            imageData.image[viewPagerPosition].copyright
        )
        binding.detailCopyrightTV.text = copyright
        binding.detailExplanationTV.text = imageData.image[viewPagerPosition].explanation
        binding.detailDateTV.text = imageData.image[viewPagerPosition].date

        binding.detailFullScreenIV.setOnClickListener {
            fullScreenClickListener.onClick(viewPagerPosition)
        }

    }

}