package com.victor.test.mybookshop.presenter

import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.utils.coroutine

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
class BooksPresenterImpl(private val booksRepository:BooksRepository): BooksPresenter() {

    var booksView:BooksView? =  null
    var bookList:ArrayList<Book> = ArrayList()


    override fun setView(booksView: BooksView) {
        this.booksView = booksView
    }

    override suspend fun getBookList(letter: String, nextIndex:Int) {
        booksView?.showProgressBar()

        coroutine {
            booksRepository.getBookList(letter, nextIndex)
        }.await().let { result ->
            booksView?.showReceivedBookList(result.first ?: bookList)
            booksView?.hideProgressBar()
        }
    }

    override fun onDestroy() {
        booksView = null
    }
}