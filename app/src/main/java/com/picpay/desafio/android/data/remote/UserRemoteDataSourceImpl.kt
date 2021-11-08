package com.picpay.desafio.android.data.remote

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.mapper.toDomain
import com.picpay.desafio.android.domain.model.User

class UserRemoteDataSourceImpl(
    private val api: PicPayService
) : UserRemoteDataSource {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }
}