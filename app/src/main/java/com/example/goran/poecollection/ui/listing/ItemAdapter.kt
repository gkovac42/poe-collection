package com.example.goran.poecollection.ui.listing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.goran.poecollection.R
import com.example.goran.poecollection.data.Item
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(val items: ArrayList<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {

            txtItemTitle.text = item.title
            txtItemTitle.setOnClickListener {
                listener(item)
            }
        }
    }
}