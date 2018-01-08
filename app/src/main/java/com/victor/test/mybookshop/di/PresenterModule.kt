package com.victor.test.mybookshop.di

import android.content.Context
import com.victor.test.mybookshop.presenter.BooksPresenter
import com.victor.test.mybookshop.presenter.BooksPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by victor on 14/11/17.
 *
 */

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providePresenter():BooksPresenter = BooksPresenterImpl()
}