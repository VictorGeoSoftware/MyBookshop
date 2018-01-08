package com.victor.test.mybookshop

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.victor.test.mybookshop.presenter.BooksPresenterImpl
import com.victor.test.mybookshop.presenter.BooksRepository
import com.victor.test.mybookshop.presenter.BooksView
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BooksPresenterTest {

    @Mock lateinit var booksView: BooksView
    @Mock lateinit var booksRepository: BooksRepository
    lateinit var booksPresenter: BooksPresenterImpl



    // --------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------- INITIALIZATION FUNCTIONS ---------------------------------------------
    private fun createMockedPresenter(): BooksPresenterImpl {
        val presenter = BooksPresenterImpl()
        presenter.booksView = booksView
        return presenter
    }



    // --------------------------------------------------------------------------------------------------------------------
    // ----------------------------------------------------- TEST ---------------------------------------------------------
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        booksPresenter = createMockedPresenter()
    }


    @Test
    fun `should peform a first search on start`() {
        whenever(booksRepository.getBookList()).thenReturn(Pair(ArrayList(), null))

        runBlocking { booksPresenter.getBookList() }

        verify(booksRepository, times(1)).getBookList()
    }
}
