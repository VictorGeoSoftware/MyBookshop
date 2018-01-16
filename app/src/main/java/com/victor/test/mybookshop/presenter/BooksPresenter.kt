package com.victor.test.mybookshop.presenter

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
abstract class BooksPresenter {
    open fun setView(booksView: BooksView) {}
    open suspend fun getBookList(letter:String, nextIndex:Int) {}
    open fun onDestroy() {}
}