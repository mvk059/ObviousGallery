package com.mvk.obviousgallery.data.model

import com.google.gson.annotations.SerializedName


data class Image(

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("explanation")
    val explanation: String,

    @SerializedName("hdurl")
    val hdurl: String,

    @SerializedName("media_type")
    val mediaType: String,

    @SerializedName("serviceVersion")
    val serviceVersion: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
)