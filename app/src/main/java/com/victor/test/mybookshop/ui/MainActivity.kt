package com.victor.test.mybookshop.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.victor.test.mybookshop.ParentActivity
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.app
import com.victor.test.mybookshop.data.Letter
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.di.mainactivity.MainActivityModule
import com.victor.test.mybookshop.ui.adapters.AlphabetListAdapter
import com.victor.test.mybookshop.ui.adapters.SpaceDecorator
import com.victor.test.mybookshop.ui.fragments.BookListFragment
import com.victor.test.mybookshop.utils.MyUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ParentActivity(), AlphabetListAdapter.LetterClickListener {

    private val component by lazy { app.component.plus(MainActivityModule(this)) }
    private lateinit var alphabetAdapter:AlphabetListAdapter


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ ACTIVITY LIFECYCLE --------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        lstAlphabet.layoutManager = horizontalLayoutManager
        lstAlphabet.addItemDecoration(SpaceDecorator(MyUtils.getDpFromValue(this, 10)))


        val letterArrayList = ArrayList<Letter>()
        MyConstants.alphabetArrayList.mapTo(letterArrayList) { Letter(it, false) }
        alphabetAdapter = AlphabetListAdapter(letterArrayList, this)
        lstAlphabet.adapter = alphabetAdapter
        alphabetAdapter.setItemSelected(letterArrayList[0])

        supportFragmentManager.beginTransaction().add(
                fragmentLayout.id,
                BookListFragment.newInstance("a"),
                MyConstants.FRAGMENT_BOOK_LIST
        ).commit()
    }


    override fun onLetterClick(letter: Letter) {
        alphabetAdapter.setItemSelected(letter)

        supportFragmentManager.beginTransaction().replace(
                fragmentLayout.id,
                BookListFragment.newInstance(letter.letter),
                MyConstants.FRAGMENT_BOOK_LIST
        ).commit()
    }
}
