package com.victor.test.mybookshop.presenter

import android.util.Log
import com.google.gson.JsonSyntaxException
import com.victor.test.mybookshop.BuildConfig
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.BookResponse
import com.victor.test.mybookshop.di.DaggerRepositoryComponent
import com.victor.test.mybookshop.di.RepositoryComponent
import com.victor.test.mybookshop.di.RepositoryModule
import com.victor.test.mybookshop.network.BookRequest
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
class BooksRepositoryImpl:BooksRepository {

    @Inject lateinit var bookRequest:BookRequest

    private val component: RepositoryComponent by lazy {
        DaggerRepositoryComponent.builder().repositoryModule(RepositoryModule(this)).build()
    }


    init {
        component.inject(this)
    }


    override fun getBookList(nextIndex:Int): Pair<ArrayList<Book>?, String?> {

        val params = HashMap<String, String>()
        params.put("key", BuildConfig.API_KEY)
        params.put("q", "a")
        params.put("startIndex", nextIndex.toString())

        val call: Call<BookResponse> = bookRequest.getCharacterComics(params)

        return try {
            val response: Response<BookResponse> = call.execute()
//            Log.i("MyBookshop", "BooksRepositoryImpl - getBookList - response :: " + response.body())

            if (response.isSuccessful && response.body() != null) {

//                Log.i("MyBookshop", "BooksRepositoryImpl - getBookList - items :: " + response.body()?.items?.size)

                Pair(response.body()?.items, null)
            } else {
                Pair(null, "Server error")
            }
        } catch (e:JsonSyntaxException) {
            Pair(null, e.localizedMessage)
        }
    }
}