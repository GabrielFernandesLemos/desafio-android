package com.picpay.desafio.android.data.local

import com.picpay.desafio.android.data.mapper.toDomain
import com.picpay.desafio.android.data.mapper.toEntity
import com.picpay.desafio.android.domain.model.User

class UserCacheDataSourceImpl(
    private val userDao: UserDao
) : UserCacheDataSource {
    override suspend fun getUser(): List<User> {
        return userDao.getAllUsers().map { it.toDomain() }
    }

    override suspend fun save(userList: List<User>) {
        userDao.insertAllUsers(userList.map { it.toEntity() })
    }

}