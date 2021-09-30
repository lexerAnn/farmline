package com.example.farmline.data.network

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class NewsData(
    @SerializedName("status")
    @Expose
    val status: String,
    @SerializedName("totalResults")
    @Expose
    val totalResponse: String,
    @SerializedName("articles")
    @Expose
    val articles: MutableList<NewsArticles>
) : Parcelable


