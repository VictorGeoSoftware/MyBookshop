package com.victor.test.mybookshop.presenter

import com.victor.test.mybookshop.data.Book

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
interface BooksRepository {
    fun getBookList(letter:String, nextIndex:Int): Pair<ArrayList<Book>?, String?>

    interface RequestListener {
        fun onBookListReceived(bookList: ArrayList<Book>)
        fun onBookListKo(error:String)
    }
}