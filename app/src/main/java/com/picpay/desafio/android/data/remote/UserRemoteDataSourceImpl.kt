package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.model.UserResponse
import retrofit2.Response

class UserRemoteDataSourceImpl(
    private val api: PicPayService
) : UserRemoteDataSource {
    override suspend fun get(): Response<List<UserResponse>?>? = api.getUsers()
}