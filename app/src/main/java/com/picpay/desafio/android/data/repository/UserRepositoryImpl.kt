package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.local.UserCacheDataSource
import com.picpay.desafio.android.data.remote.UserRemoteDataSource
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource,
    private val cacheDataSource: UserCacheDataSource
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return runCatching {
            val users = remoteDataSource.getUsers()
            cacheDataSource.save(users)
            cacheDataSource.getUser()
        }.getOrElse {
            cacheDataSource.getUser()
        }
    }
}