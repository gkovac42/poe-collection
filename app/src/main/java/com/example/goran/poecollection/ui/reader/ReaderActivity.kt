package com.example.goran.poecollection.ui.reader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.goran.poecollection.R
import kotlinx.android.synthetic.main.activity_reader.*

class ReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)

        val title = intent.getStringExtra("reader_title")
        val body = intent.getStringExtra("reader_body")

        txtReaderTitle.text = title
        txtReaderBody.text = body
        txtReaderBody.setZoomLimit(2.0f)
    }
}
