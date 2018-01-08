package com.victor.test.mybookshop

import android.app.Application
import com.victor.test.mybookshop.di.AppComponent
import com.victor.test.mybookshop.di.AppModule
import com.victor.test.mybookshop.di.DaggerAppComponent

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
class ParentApplication:Application() {

    val component:AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}