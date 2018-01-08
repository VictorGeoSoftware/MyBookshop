package com.victor.test.mybookshop.di

import android.content.Context
import com.victor.test.mybookshop.presenter.BooksPresenter
import com.victor.test.mybookshop.presenter.BooksPresenterImpl
import com.victor.test.mybookshop.presenter.BooksRepository
import com.victor.test.mybookshop.presenter.BooksRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by victor on 14/11/17.
 *
 */

@Module
class RepositoryModule(private val booksRepositoryImpl: BooksRepositoryImpl) {

    @Provides
    @Singleton
    fun provideRepository():BooksRepository = booksRepositoryImpl
}