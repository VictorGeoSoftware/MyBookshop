package com.victor.test.mybookshop.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.victor.test.mybookshop.ui.fragments.BookListFragment


/**
 * Created by victorpalmacarrasco on 10/1/18.
 * ${APP_NAME}
 */
class BookAlphabetPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = LinkedHashMap<BookListFragment, String>()


    override fun getItem(position: Int): Fragment {
        return fragments.keys.elementAt(position)
    }

    override fun getCount(): Int {
        return  fragments.keys.size
    }

    fun addFragment(fragment: BookListFragment, title: String) {
        fragments.put(fragment, title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments.values.elementAt(position)
    }

}