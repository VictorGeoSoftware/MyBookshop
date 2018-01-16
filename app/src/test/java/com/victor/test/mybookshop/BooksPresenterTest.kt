package com.victor.test.mybookshop

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.victor.test.mybookshop.data.Book
import com.victor.test.mybookshop.presenter.BooksPresenterImpl
import com.victor.test.mybookshop.presenter.BooksRepository
import com.victor.test.mybookshop.presenter.BooksView
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyList
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
        val presenter = BooksPresenterImpl(booksRepository)
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
    fun `should peform a first search on start with "a" request`() {
        val a = "a"
        val firstIndex = 0
        whenever(booksRepository.getBookList(a, firstIndex)).thenReturn(Pair(ArrayList(), null))

        runBlocking { booksPresenter.getBookList(a, firstIndex) }

        verify(booksRepository, times(1)).getBookList(a, firstIndex)
    }

    @Test
    fun `should fill recyclerview with received list in any search`() {
        val letter = "a"
        val firstIndex = 0

        whenever(booksRepository.getBookList(letter, firstIndex)).thenReturn(Pair(ArrayList(), null))

        runBlocking { booksPresenter.getBookList(letter, firstIndex) }

        verify(booksView).showReceivedBookList(ArrayList())
    }

    @Test
    fun `should perform a search when some letter is tapped`() {
        val letter = "b"
        val firstIndex = 0

        whenever(booksRepository.getBookList(letter, firstIndex)).thenReturn(Pair(ArrayList(), null))

        runBlocking {
            booksPresenter.getBookList(letter, firstIndex)
        }

        verify(booksView).showReceivedBookList(ArrayList())
    }
}
