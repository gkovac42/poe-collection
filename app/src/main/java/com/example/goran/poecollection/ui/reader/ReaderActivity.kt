package com.example.goran.poecollection.ui.reader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.goran.poecollection.R
import com.example.goran.poecollection.ui.listing.EXTRA_BODY
import com.example.goran.poecollection.ui.listing.EXTRA_TITLE
import kotlinx.android.synthetic.main.activity_reader.*

class ReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val body = intent.getStringExtra(EXTRA_BODY)

        txtReaderTitle.text = title
        txtReaderBody.text = body
        txtReaderBody.setZoomLimit(2.0f)
    }
}
