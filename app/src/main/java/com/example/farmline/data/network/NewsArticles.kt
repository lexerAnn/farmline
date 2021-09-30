package com.example.farmline.data.network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsArticles(
    @SerializedName("author")
    @Expose
    var author: String?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("description")
    @Expose
    var description: String?,
    @SerializedName("url")
    @Expose
    val url: String?,
    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String?,
): Parcelable