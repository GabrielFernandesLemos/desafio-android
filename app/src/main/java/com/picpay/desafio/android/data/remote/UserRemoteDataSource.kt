package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.model.UserResponse

interface UserRemoteDataSource {
    suspend fun get(): List<UserResponse>
}