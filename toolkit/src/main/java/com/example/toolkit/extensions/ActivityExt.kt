package com.example.toolkit.extensions

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard(){
    requireActivity().hideKeyBoard()
}

fun Activity.hideKeyBoard() {
    val view = this.currentFocus
    view ?: return
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}