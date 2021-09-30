package com.example.farmline.generics

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Failure<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
}