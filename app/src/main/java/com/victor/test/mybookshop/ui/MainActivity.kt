package com.victor.test.mybookshop.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.victor.test.mybookshop.ParentActivity
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.app
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.di.mainactivity.MainActivityModule
import com.victor.test.mybookshop.presenter.BooksPresenter
import com.victor.test.mybookshop.presenter.BooksView
import com.victor.test.mybookshop.ui.adapters.BookListAdapter
import com.victor.test.mybookshop.ui.adapters.SpaceDecorator
import com.victor.test.mybookshop.utils.MyUtils
import com.victor.test.mybookshop.utils.coroutine
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject

class MainActivity : ParentActivity(), BooksView, BookListAdapter.BookAdapterListener {

    private val component by lazy { app.component.plus(MainActivityModule(this)) }
    @Inject lateinit var booksPresenter:BooksPresenter
    private lateinit var bookListAdapter: BookListAdapter
    private val bookArrayList: ArrayList<Book> = ArrayList()


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ ACTIVITY LIFECYCLE --------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        booksPresenter.setView(this)

        val myGridLayoutManager = GridLayoutManager(this, 2)
        lstBooks.layoutManager = myGridLayoutManager
        lstBooks.addItemDecoration(SpaceDecorator(MyUtils.getDpFromValue(this, 10)))

        bookListAdapter = BookListAdapter(bookArrayList, this)
        lstBooks.adapter = bookListAdapter

        runBlocking { booksPresenter.getBookList(0) }

        lstBooks.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val nextIndex =  bookListAdapter.itemCount

                if (myGridLayoutManager.findLastCompletelyVisibleItemPosition() == nextIndex - 1) {
                    Handler().postDelayed({ runBlocking { updateBookList(nextIndex) } }, 500)
                }
            }
        })
    }



    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ BOOKS VIEW INTERFACE ------------------------------------------------------------
    override fun showProgressBar() {
//        Log.i("MyBookshop", "MainActivity - showProgressBar!")
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
//        Log.i("MyBookshop", "MainActivity - hideProgressBar!")
        progressBar.visibility = View.INVISIBLE
    }

    override fun showReceivedBookList(bookList: ArrayList<Book>?) {
//        Log.i("MyBookshop", "MainActivity - showReceivedBookList :: " + bookList)
//        bookArrayList.addAll(bookArrayList)
//        bookListAdapter.notifyDataSetChanged()

        bookListAdapter.updateBookList(bookList!!)
    }



    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ BOOKS ADAPTER LISTENER ----------------------------------------------------------
    override fun onBookSelected(book: Book) {
        // TODO :: integrate transitions between activities
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(MyConstants.BOOK, book)
        startActivity(intent)
    }



    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ METHODS AND RUNNABLES -----------------------------------------------------------
    suspend fun updateBookList(nextIndex: Int) {
        booksPresenter.getBookList(nextIndex)
    }
}
