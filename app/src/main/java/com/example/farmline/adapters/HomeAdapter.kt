package com.example.farmline.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.farmline.data.network.NewsArticles
import com.example.farmline.data.network.NewsData
import com.example.farmline.databinding.ListItemHomeBinding
import com.example.farmline.generics.BaseRecyclerAdapter
import com.example.farmline.generics.BaseRecyclerItemListener
import com.example.farmline.viewHolders.HomeVH


class HomeAdapter (
    private val itemListener: BaseRecyclerItemListener<NewsArticles>? = null
):BaseRecyclerAdapter<NewsArticles, HomeVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        return HomeVH(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemListener
        )
    }

    override fun areItemsTheSame(oldItem: NewsArticles, newItem: NewsArticles): Boolean {
        return oldItem.title == newItem.title
    }

}