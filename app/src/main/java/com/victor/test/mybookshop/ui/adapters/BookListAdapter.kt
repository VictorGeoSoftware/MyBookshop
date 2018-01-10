package com.victor.test.mybookshop.ui.adapters

import android.provider.SyncStateContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.utils.inflate
import kotlinx.android.synthetic.main.adapter_book_list.view.*

/**
 * Created by victorpalmacarrasco on 8/1/18.
 * ${APP_NAME}
 */
class BookListAdapter(private val bookList: ArrayList<Book>, private val booksAdapterListener: BookAdapterListener):
        RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
            BookViewHolder(parent.inflate(R.layout.adapter_book_list))

    override fun onBindViewHolder(holder: BookViewHolder?, position: Int) {
        Log.i("MyBookshop", "BookListAdapter - onBindViewHolder - position " + position)
        holder?.bind(bookList[position], booksAdapterListener)
    }

    override fun getItemCount(): Int = bookList.size

    fun updateBookList(bookList: ArrayList<Book>) {
        this.bookList.addAll(bookList)
        notifyDataSetChanged()
    }


    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book, listener: BookAdapterListener) = with(itemView) {

            Picasso.with(context).load(book.volumeInfo.imageLinks?.smallThumbnail).into(imgBookTape)
            txtTitle.text = book.volumeInfo.title

            val price:String = if (book.saleInfo.saleability.contentEquals(MyConstants.FOR_SALE)) {
                "${book.saleInfo.listPrice!!.amount} ${book.saleInfo.listPrice.currencyCode}"
            } else {
                context.getString(R.string.free)
            }

            txtPrice.text = price
            setOnClickListener { listener.onBookSelected(book) }

        }
    }

    interface BookAdapterListener {
        fun onBookSelected(book: Book)
    }
}