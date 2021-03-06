package com.example.goran.poecollection.ui.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.goran.poecollection.R
import com.example.goran.poecollection.ui.about.AboutFragment
import com.example.goran.poecollection.ui.listing.ListingFragment
import com.example.goran.poecollection.ui.listing.MODE_POEMS
import com.example.goran.poecollection.ui.listing.MODE_STORIES
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private lateinit var fragments: Array<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fragments = initFragments()

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        viewPager.adapter = mSectionsPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
    }

    private fun initFragments(): Array<Fragment> {
        val aboutFragment = AboutFragment()
        val storiesFragment = ListingFragment.newInstance(MODE_STORIES)
        val poemsFragment = ListingFragment.newInstance(MODE_POEMS)

        return arrayOf(aboutFragment, storiesFragment, poemsFragment)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }
}
