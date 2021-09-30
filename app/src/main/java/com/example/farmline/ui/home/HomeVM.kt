package com.example.farmline.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.farmline.adapters.HomeAdapter
import com.example.farmline.data.network.NewsArticles
import com.example.farmline.generics.BaseRecyclerItemListener
import com.example.farmline.generics.DataState
import com.example.farmline.repository.newRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val newRepository: newRepository

):ViewModel(),BaseRecyclerItemListener<NewsArticles> {
    val recipientsListAdapter: ObservableField<HomeAdapter> = ObservableField()
    fun initialize() {
        val adapter = HomeAdapter(this)
        viewModelScope.launch {
            when (val response = newRepository.getNewsFromApi()) {
                is DataState.Success -> {
                    val list = response.data as List<NewsArticles>
                    adapter.submitList(list)
                    recipientsListAdapter.set(adapter)


                }
                is DataState.Failure -> {
                    Timber.d(response.data.toString())
                }
                is DataState.Error -> {
                    Timber.d(response.exception.localizedMessage)
                }
            }
        }
    }

    fun displayData(dataList: List<*>) {

    }

    override fun onItemClicked(view: View?, position: Int, modelItem: NewsArticles) {
        var newsData=NewsArticles(modelItem.author,modelItem.title,modelItem.description,modelItem.urlToImage,modelItem.url)
         val action = view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(newsData))

    }
}