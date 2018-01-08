package com.victor.test.mybookshop.utils

import android.content.Context
import android.util.TypedValue

/**
 * Created by victor on 13/11/17.
 *
 */
class MyUtils {
    companion object {
        fun getDpFromValue(context: Context, value: Int): Int =
                Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), context.resources.displayMetrics))
    }

}