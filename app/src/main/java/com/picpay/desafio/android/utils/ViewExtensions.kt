package com.picpay.desafio.android.utils

import android.content.Context
import android.widget.Toast
import com.picpay.desafio.android.R

fun Context.errorToast() {
    Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show()
}
