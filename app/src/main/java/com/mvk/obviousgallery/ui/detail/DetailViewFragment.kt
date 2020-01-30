/*
 * Created by Manpreet Kunnath on 29/1/2020 18:1
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.obviousgallery.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvk.obviousgallery.R
import com.mvk.obviousgallery.data.model.ImageData
import com.mvk.obviousgallery.databinding.DetailViewMainBinding
import com.mvk.obviousgallery.ui.detail.adapter.DetailViewAdapter
import com.mvk.obviousgallery.ui.main.viewmodel.MainViewModel


class DetailViewFragment : Fragment() {

    companion object {
        fun newInstance() = DetailViewFragment()
    }

    private lateinit var binding: DetailViewMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_view_main, container, false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}