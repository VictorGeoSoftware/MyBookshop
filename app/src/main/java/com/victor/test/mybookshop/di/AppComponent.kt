package com.victor.test.mybookshop.di

import android.app.Application
import com.victor.test.mybookshop.di.mainactivity.MainActivityComponent
import com.victor.test.mybookshop.di.mainactivity.MainActivityModule
import com.victor.test.mybookshop.presenter.BooksRepositoryImpl
import com.victor.test.mybookshop.ui.fragments.BookListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(application: Application)
    fun inject(booksRepositoryImpl: BooksRepositoryImpl)
    fun inject(target: BookListFragment)
    fun plus(mainActivityModule: MainActivityModule): MainActivityComponent
}