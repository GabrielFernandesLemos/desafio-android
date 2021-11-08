package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.domain.model.User

interface UserRemoteDataSource{
    suspend fun getUsers(): List<User>
}