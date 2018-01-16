package com.victor.test.mybookshop.presenter

import com.victor.test.mybookshop.data.Book


/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
interface BooksRepository {

    fun getBookList(letter: String, nextIndex:Int): Pair<ArrayList<Book>?, kotlin.String?>

}