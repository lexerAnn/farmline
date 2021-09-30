package com.example.farmline.ui

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.farmline.data.network.NewsArticles
import com.example.farmline.data.network.NewsData
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsVM @Inject constructor():ViewModel() {
    val name = ObservableField<String>()
    private lateinit var selectedNewsData: NewsArticles
    fun initiate(context: Context?, selectedNewsData: NewsArticles?) {
        selectedNewsData?.run {
            this@DetailsVM.selectedNewsData = this
            println("Info${this.title}")
            Timber.d(selectedNewsData.author)
            Toast.makeText(context,"${selectedNewsData.author}",Toast.LENGTH_LONG).show()
        }
        name.set(selectedNewsData?.title)

    }
}