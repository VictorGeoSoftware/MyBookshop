package com.victor.test.mybookshop.presenter

import android.util.Log
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.utils.MyUtils
import com.victor.test.mybookshop.utils.coroutine

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
class BooksPresenterImpl:BooksPresenter, BooksRepository.RequestListener {

    var booksView:BooksView? =  null
    var booksRepository:BooksRepository = BooksRepositoryImpl()


    override fun setView(booksView: BooksView) {
        this.booksView = booksView
    }

    override suspend fun getBookList(nextIndex:Int) {
        booksView?.showProgressBar()

        coroutine {
            booksRepository.getBookList(nextIndex)
        }.await().let { result ->
            booksView?.hideProgressBar()
            booksView?.showReceivedBookList(result.first)
        }
    }

    override fun onDestroy() {
        booksView = null
    }



    // ---------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ INTERACTOR LISTENER ------------------------------------------------------------
    override fun onBookListReceived(bookList: ArrayList<Book>) {

    }

    override fun onBookListKo(error: String) {

    }
}