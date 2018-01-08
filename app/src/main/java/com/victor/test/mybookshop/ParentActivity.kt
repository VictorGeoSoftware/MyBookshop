package com.victor.test.mybookshop

import android.app.Activity
import android.support.v7.app.AppCompatActivity

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
open class ParentActivity: AppCompatActivity() {


}

val Activity.app: ParentApplication
    get() = application as ParentApplication