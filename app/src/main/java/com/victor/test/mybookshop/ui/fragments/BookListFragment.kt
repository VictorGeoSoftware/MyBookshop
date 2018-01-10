package com.victor.test.mybookshop.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.app
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.presenter.BooksPresenter
import com.victor.test.mybookshop.presenter.BooksView
import com.victor.test.mybookshop.ui.DetailActivity
import com.victor.test.mybookshop.ui.adapters.BookListAdapter
import com.victor.test.mybookshop.ui.adapters.SpaceDecorator
import com.victor.test.mybookshop.utils.MyUtils
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject

/**
 * Created by victorpalmacarrasco on 9/1/18.
 * ${APP_NAME}
 */
class BookListFragment: Fragment(), BooksView, BookListAdapter.BookAdapterListener {

    @Inject lateinit var booksPresenter: BooksPresenter
    private lateinit var bookListAdapter: BookListAdapter
    private val bookArrayList: ArrayList<Book> = ArrayList()
    private lateinit var fragmentLetter:String


    companion object {
        fun newInstance(letter:String): BookListFragment {
            val args = Bundle()
            args.putString(MyConstants.LETTER, letter)

            val fragment = BookListFragment()
            fragment.arguments = args

            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_book_list, container, false)
        activity.app.component.inject(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        booksPresenter.setView(this)
        fragmentLetter = arguments.getString(MyConstants.LETTER, "")

        val myGridLayoutManager = GridLayoutManager(activity, 2)
        lstBooks.layoutManager = myGridLayoutManager
        lstBooks.addItemDecoration(SpaceDecorator(MyUtils.getDpFromValue(activity, 10)))

        bookListAdapter = BookListAdapter(bookArrayList, this)
        lstBooks.adapter = bookListAdapter

        runBlocking { booksPresenter.getBookList(fragmentLetter, 0) }

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
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showReceivedBookList(bookList: ArrayList<Book>?) {
        bookListAdapter.updateBookList(bookList!!)
    }


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ BOOKS ADAPTER LISTENER ----------------------------------------------------------
    override fun onBookSelected(book: Book) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(MyConstants.BOOK, book)
        startActivity(intent)
    }


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ METHODS AND RUNNABLES -----------------------------------------------------------
    suspend fun updateBookList(nextIndex: Int) {
        booksPresenter.getBookList(fragmentLetter, nextIndex)
    }
}