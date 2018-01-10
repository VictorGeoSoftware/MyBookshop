package com.victor.test.mybookshop.presenter

import com.victor.test.mybookshop.data.Book
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

    override suspend fun getBookList(letter: String, nextIndex:Int) {
        booksView?.showProgressBar()

        coroutine {
            booksRepository.getBookList(letter, nextIndex)
        }.await().let { result ->
            booksView?.showReceivedBookList(result.first)
            booksView?.hideProgressBar()
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