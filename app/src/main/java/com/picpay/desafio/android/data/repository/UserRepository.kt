package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.model.UserResponse
import retrofit2.Response

interface UserRepository {
    suspend fun getUsers() : Response<List<UserResponse>?>?
}