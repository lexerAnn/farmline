package com.example.farmline.generics

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<Model, VH : BaseRecyclerViewHolder<Model>>(
    private val itemListener: BaseRecyclerItemListener<Model>? = null,
) : RecyclerView.Adapter<VH>() {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    abstract fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean

    fun submitList(list: List<Model>) {
        differ.submitList(list)
    }
}