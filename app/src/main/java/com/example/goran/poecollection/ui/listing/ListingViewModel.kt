package com.example.goran.poecollection.ui.listing

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.goran.poecollection.data.Item
import com.example.goran.poecollection.data.ItemsRepo

class ListingViewModel(app: Application) : AndroidViewModel(app) {

    private val repo: ItemsRepo = ItemsRepo(app)

    val stories: MutableLiveData<List<Item>> = MutableLiveData()
    val poems: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        stories.postValue(repo.getStories())
        poems.postValue(repo.getPoems())
    }
}