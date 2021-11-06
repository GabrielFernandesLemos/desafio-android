package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.model.UserResponse
import com.picpay.desafio.android.data.remote.UserRemoteDataSource
import retrofit2.Response

class UserRepositoryImpl(
    private val datasource : UserRemoteDataSource
) : UserRepository {

    override suspend fun getUsers(): Response<List<UserResponse>?>? {
        return datasource.get()
    }
}