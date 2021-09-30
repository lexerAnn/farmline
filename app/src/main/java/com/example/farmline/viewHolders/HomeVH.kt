package com.example.farmline.viewHolders

import com.example.farmline.data.network.NewsArticles
import com.example.farmline.data.network.NewsData
import com.example.farmline.databinding.ListItemHomeBinding
import com.example.farmline.generics.BaseRecyclerItemListener
import com.example.farmline.generics.BaseRecyclerViewHolder
import timber.log.Timber

class HomeVH(
    private val binding: ListItemHomeBinding,
    private val itemListener: BaseRecyclerItemListener <NewsArticles>?=null
) : BaseRecyclerViewHolder<NewsArticles>(binding.root){
    override fun onBind(modelItem: NewsArticles) = with(binding.root){
        setOnClickListener {
            itemListener?.onItemClicked(it, adapterPosition, modelItem)
        }
        binding.lifecycleOwner = binding.lifecycleOwner
        Timber.d("wallet item : ${modelItem.title} ${modelItem.author}")
        binding.model = modelItem
        binding.executePendingBindings()
    }
}