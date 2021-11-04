package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.ui.entity.User

interface UserRepository {
    suspend fun getUsers() : List<User>
}