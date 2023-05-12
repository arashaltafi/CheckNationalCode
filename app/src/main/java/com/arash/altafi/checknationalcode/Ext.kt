package com.arash.altafi.checknationalcode

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.toGone() {
    visibility = View.GONE
}

fun View.toHide() {
    visibility = View.INVISIBLE
}

fun View.toShow() {
    visibility = View.VISIBLE
}

fun View.showKeyboard() {
    this.requestFocus()
    try {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    } catch (e: java.lang.Exception) {
        println("showKeyboard failed, error: $e")
    }
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}