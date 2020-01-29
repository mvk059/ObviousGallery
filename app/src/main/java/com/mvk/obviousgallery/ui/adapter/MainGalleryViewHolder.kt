/*
 * Created by Manpreet Kunnath on 29/1/2020 11:2
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.Image
import com.mvk.obviousgallery.databinding.ItemViewHomeMainBinding

// A bare bones implementation of the recycler view holder. Will change later
class MainGalleryViewHolder(var binding: ItemViewHomeMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItems(context: Context, image: Image) {
        binding.rvItemHomeMain.setImageResource(R.drawable.hubble)
    }
}