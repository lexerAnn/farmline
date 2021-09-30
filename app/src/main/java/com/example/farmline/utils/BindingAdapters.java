package com.example.farmline.utils;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmline.generics.BaseRecyclerAdapter;

public class BindingAdapters {
    @BindingAdapter("recyclerAdapter")
    public static void setRecyclerAdapter(RecyclerView recyclerView, BaseRecyclerAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
}
