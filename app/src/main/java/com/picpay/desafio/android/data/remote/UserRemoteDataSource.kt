package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.model.UserResponse
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun get(): Response<List<UserResponse>?>?
}