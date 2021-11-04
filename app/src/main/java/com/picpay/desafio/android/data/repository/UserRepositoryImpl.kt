package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.remote.UserRemoteDataSource
import com.picpay.desafio.android.ui.entity.User

class UserRepositoryImpl(
    private val dataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsers(): List<User> =
        dataSource.get()
            .map { response ->
                User(
                    id = response.id,
                    name = response.name,
                    username = response.username,
                    img = response.img
                )
            }
}