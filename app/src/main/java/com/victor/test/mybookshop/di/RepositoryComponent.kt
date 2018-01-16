package com.victor.test.mybookshop.di

import com.victor.test.mybookshop.presenter.BooksRepository
import com.victor.test.mybookshop.presenter.BooksRepositoryImpl
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface RepositoryComponent {

    fun inject(booksRepositoryImpl: BooksRepositoryImpl)
}