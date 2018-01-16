package com.victor.test.mybookshop.di

import com.victor.test.mybookshop.presenter.BooksRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by victor on 14/11/17.
 *
 */

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository():BooksRepositoryImpl = BooksRepositoryImpl()
}