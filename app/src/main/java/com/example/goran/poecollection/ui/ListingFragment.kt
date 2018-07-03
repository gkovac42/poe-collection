package com.example.goran.poecollection.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.goran.poecollection.R
import com.example.goran.poecollection.data.Item
import kotlinx.android.synthetic.main.fragment_listing.*
import java.util.*

class ListingFragment : Fragment() {

    companion object {
        private const val EXTRA_TITLES = "listing_titles"
        private const val EXTRA_BODIES = "listing_bodies"

        fun newInstance(titlesRes: Int, bodiesRes: Int): ListingFragment {
            val args = Bundle()
            args.putInt(EXTRA_TITLES, titlesRes)
            args.putInt(EXTRA_BODIES, bodiesRes)

            val fragment = ListingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titlesRes = arguments!!.getInt(EXTRA_TITLES)
        val bodiesRes = arguments!!.getInt(EXTRA_BODIES)

        val viewModel = ViewModelProviders.of(this).get(ListingViewModel::class.java)
        viewModel.getItemsFromArraysRes(titlesRes, bodiesRes)
                .observe(this, android.arch.lifecycle.Observer {
                    initRecycler(initAdapter(it!!))
                })
    }

    private fun initRecycler(adapter: ItemAdapter): RecyclerView {
        val recycler = recyclerView
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter
        return recycler
    }

    private fun initAdapter(itemList: ArrayList<Item>): ItemAdapter {
        return ItemAdapter(itemList) {
            startReading(it)
        }
    }

    private fun startReading(item: Item) {
        val readIntent = Intent(activity, ReaderActivity::class.java)
        readIntent.putExtra("reader_title", item.title)
        readIntent.putExtra("reader_body", item.body)
        startActivity(readIntent)
    }
}