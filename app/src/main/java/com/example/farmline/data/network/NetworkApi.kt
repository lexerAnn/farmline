package com.example.farmline.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    companion object{
        const val API_KEY="91b2475438934ab4a7cd53dc42f8da51"
        const val sources_="techcrunch"

    }
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("sources")source:String= sources_,
        @Query("apiKey")api_key:String = API_KEY):Response <NewsData>
}