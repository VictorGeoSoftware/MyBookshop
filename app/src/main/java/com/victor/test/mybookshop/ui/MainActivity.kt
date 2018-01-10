package com.victor.test.mybookshop.ui

import android.os.Bundle
import com.victor.test.mybookshop.ParentActivity
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.app
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.di.mainactivity.MainActivityModule
import com.victor.test.mybookshop.ui.adapters.BookAlphabetPagerAdapter
import com.victor.test.mybookshop.ui.fragments.BookListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ParentActivity() {

    private val component by lazy { app.component.plus(MainActivityModule(this)) }


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ ACTIVITY LIFECYCLE --------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)


        val pagerAdapter = BookAlphabetPagerAdapter(supportFragmentManager)

        for (letter in MyConstants.alphabetArrayList) {
            val bookListFragment:BookListFragment = BookListFragment.newInstance(letter)
            pagerAdapter.addFragment(bookListFragment, letter)
        }

        viewPager.adapter = pagerAdapter
    }




}
