package com.example.goran.poecollection.ui.listing

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.goran.poecollection.R
import com.example.goran.poecollection.data.Item
import com.example.goran.poecollection.ui.reader.ReaderActivity
import kotlinx.android.synthetic.main.fragment_listing.*


const val MODE_STORIES = 0
const val MODE_POEMS = 1
const val EXTRA_TITLE = "item_title"
const val EXTRA_BODY = "item_body"

class ListingFragment : Fragment() {

    companion object {
        private const val EXTRA_MODE = "listing_mode"

        fun newInstance(mode: Int): ListingFragment {
            val args = Bundle()
            args.putInt(EXTRA_MODE, mode)

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

        val viewModel = ViewModelProviders.of(this).get(ListingViewModel::class.java)

        val mode = arguments?.getInt(EXTRA_MODE)

        val itemsLiveData =
                if (mode == MODE_STORIES) viewModel.stories
                else viewModel.poems

        itemsLiveData.observe(this, Observer {
            initRecycler(initAdapter(it!!))
        })
    }

    private fun initRecycler(itemAdapter: ItemAdapter) = recyclerView.apply {
        layoutManager = LinearLayoutManager(activity)
        adapter = itemAdapter
        setHasFixedSize(true)
    }

    private fun initAdapter(items: List<Item>) = ItemAdapter(items) { startReading(it) }

    private fun startReading(item: Item) = Intent(activity, ReaderActivity::class.java).apply {
        putExtra(EXTRA_TITLE, item.title)
        putExtra(EXTRA_BODY, item.body)
        startActivity(this)
    }
}