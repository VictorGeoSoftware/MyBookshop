package com.victor.test.mybookshop.network

import com.google.gson.JsonObject
import com.victor.test.mybookshop.data.BookResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap
import java.util.HashMap

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
interface BookRequest {
    @Headers("Content-Type: application/json;charset=UTF-8")

    @GET("books/v1/volumes")
    fun getCharacterComicsRx(@QueryMap params: HashMap<String, String>): Observable<Response<BookResponse>>

    @GET("books/v1/volumes")
    fun getCharacterComics(@QueryMap params: HashMap<String, String>): Call<BookResponse>
}