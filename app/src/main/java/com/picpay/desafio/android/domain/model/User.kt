package com.picpay.desafio.android.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
    val img: String,
    val username: String
): Parcelable