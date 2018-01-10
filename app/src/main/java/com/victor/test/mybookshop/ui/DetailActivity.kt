package com.victor.test.mybookshop.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.MyConstants
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val bookToShow = intent.getParcelableExtra(MyConstants.BOOK) as Book
        Picasso.with(this).load(bookToShow.volumeInfo.imageLinks?.thumbnail).into(imgTape)
        txtDescription.text = bookToShow.volumeInfo.description

        val price:String = if (bookToShow.saleInfo.saleability.contentEquals(MyConstants.FOR_SALE)) {
            "${bookToShow.saleInfo.listPrice!!.amount} ${bookToShow.saleInfo.listPrice.currencyCode}"
        } else {
            getString(R.string.free)
        }

        txtPrice.text = price

        val author = bookToShow.volumeInfo.authors?.get(0) ?: getString(R.string.unavailable)
        txtAuthor.text = author
        txtEditCompany.text = bookToShow.volumeInfo.publisher


        toolbar.setNavigationOnClickListener { finish() }

        btnLink.setOnClickListener {
            val bookUrl = bookToShow.accessInfo.webReaderLink
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl))
            startActivity(intent)
        }

        Handler().postDelayed( { toolbar.title = bookToShow.volumeInfo.title }, 100)
    }


}
