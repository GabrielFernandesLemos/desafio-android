package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.model.UserResponse

class UserRemoteDataSourceImpl(private val api: PicPayService) : UserRemoteDataSource {
    override suspend fun get(): List<UserResponse> = api.getUsers()
}