package com.example.goran.poecollection.data

import android.app.Application
import com.example.goran.poecollection.R
import java.util.*

class ItemsRepo(val app: Application) {

    fun getStories() = getItemsFromArraysRes(R.array.stories_array, R.array.stories_body_array)

    fun getPoems() = getItemsFromArraysRes(R.array.poems_array, R.array.poems_body_array)

    private fun getItemsFromArraysRes(titlesRes: Int, bodiesRes: Int): List<Item> {
        val titlesArray = app.resources.getStringArray(titlesRes)
        val bodiesArray = app.resources.getStringArray(bodiesRes)
        val items: ArrayList<Item> = ArrayList()

        for (i in titlesArray.indices) {
            val item = Item(titlesArray[i], bodiesArray[i], false)
            items.add(item)
        }

        return items
    }
}