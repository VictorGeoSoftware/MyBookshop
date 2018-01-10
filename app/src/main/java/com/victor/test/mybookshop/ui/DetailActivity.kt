package com.victor.test.mybookshop.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.victor.test.mybookshop.R
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.data.MyConstants
import com.victor.test.mybookshop.utils.snack
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private var bookToShow:Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        bookToShow = intent.getParcelableExtra(MyConstants.BOOK) as Book
        Picasso.with(this).load(bookToShow?.volumeInfo?.imageLinks?.thumbnail).into(imgTape)
        txtDescription.text = bookToShow?.volumeInfo?.description

        val price: kotlin.String = if (bookToShow?.saleInfo?.saleability!!.contentEquals(MyConstants.FOR_SALE)) {
            "${bookToShow?.saleInfo?.listPrice!!.amount} ${bookToShow?.saleInfo?.listPrice?.currencyCode}"
        } else {
            getString(R.string.free)
        }

        txtPrice.text = price

        val author = bookToShow?.volumeInfo?.authors?.get(0) ?: getString(R.string.unavailable)
        txtAuthor.text = author
        txtEditCompany.text = bookToShow?.volumeInfo?.publisher


        toolbar.setNavigationOnClickListener { finish() }
        Handler().postDelayed( { toolbar.title = bookToShow?.volumeInfo?.title }, 100)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_book_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        when (item.itemId) {
            R.id.further_info -> {
                val bookUrl = bookToShow?.accessInfo?.webReaderLink

                if (bookUrl == null) {
                    mainLayout.snack(getString(R.string.no_info_available), Snackbar.LENGTH_SHORT, {})
                } else {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl))
                    startActivity(intent)
                }
            }
        }

        return false
    }

}
