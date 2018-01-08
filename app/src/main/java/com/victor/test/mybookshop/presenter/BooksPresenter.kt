package com.victor.test.mybookshop.presenter

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
interface BooksPresenter {
    fun setView(booksView: BooksView)
    suspend fun getBookList(nextIndex:Int)
    fun onDestroy()
}