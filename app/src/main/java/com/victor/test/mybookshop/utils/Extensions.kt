package com.victor.test.mybookshop.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

fun <T> coroutine(function: () -> T): Deferred<T> {
    return async(CommonPool) { function() }
}

fun Pair<Any?, String?>.success(): Boolean {
    return first != null
}

fun Pair<Any?, String?>.failure(): Boolean {
    return second != null
}

fun Pair<List<Any>?, String?>.hasResults(): Boolean {
    return first != null && first?.isNotEmpty() ?: false
}

fun Pair<List<Any>?, String?>.hasNoResults(): Boolean {
    return first != null && first?.isEmpty() ?: false
}

fun Context.hideSoftKeyboard(v: View) {
    val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm?.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
}

fun Context.showSoftKeyboard(v: View) {
    val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm?.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
}

fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)