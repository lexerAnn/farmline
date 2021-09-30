package com.example.farmline.repository

import com.example.farmline.data.network.NetworkApi
import com.example.farmline.data.network.NewsData
import com.example.farmline.generics.DataState
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class newRepository @Inject constructor(
    private val networkApi: NetworkApi
) {
   
suspend fun getNewsFromApi(): DataState<Any> {
    return processDataSate(networkApi.getNews())
}

    private fun processDataSate(result: Response<NewsData>): DataState<Any> {
        try {
            val responseBody = result.body()!!.articles
            return when {
                responseBody != null -> {
                    Timber.d("success body - %s", responseBody)
                    DataState.Success(responseBody)
                }
                else -> {
                    val errorBody = result.errorBody()?.string()
                    Timber.d("error body - %s", errorBody)
                    if (errorBody != null) {
                        DataState.Failure(errorBody)
                    } else {
                        Timber.e("Neither response body or error body found")
                        throw Exception("Oops! An error occurred")
                    }
                }
            }
        } catch (e: Exception) {
            return DataState.Error(e)
        }
    }
}