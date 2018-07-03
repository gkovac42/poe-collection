package com.example.goran.poecollection.ui.listing

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.goran.poecollection.data.Item
import java.util.*

class ListingViewModel(private val app: Application) : AndroidViewModel(app) {

    fun getItemsFromArraysRes(titlesRes: Int, bodiesRes: Int): LiveData<ArrayList<Item>> {
        val itemsLiveData: MutableLiveData<ArrayList<Item>> = MutableLiveData()
        val titlesArray = app.resources.getStringArray(titlesRes)
        val bodiesArray = app.resources.getStringArray(bodiesRes)
        val items: ArrayList<Item> = ArrayList()

        for (i in titlesArray.indices) {
            val item = Item(titlesArray[i], bodiesArray[i], false)
            items.add(item)
        }

        itemsLiveData.postValue(items)
        return itemsLiveData
    }
}