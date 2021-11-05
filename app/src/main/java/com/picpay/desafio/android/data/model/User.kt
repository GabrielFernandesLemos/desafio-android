package com.picpay.desafio.android.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val img: String,
    val username: String
): Parcelable