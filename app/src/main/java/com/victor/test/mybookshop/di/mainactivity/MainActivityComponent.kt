package com.victor.test.mybookshop.di.mainactivity

import com.victor.test.mybookshop.ui.MainActivity
import dagger.Subcomponent

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}