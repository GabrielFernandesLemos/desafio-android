package com.picpay.desafio.android.data.local

import com.picpay.desafio.android.domain.model.User

interface UserCacheDataSource {
    suspend fun getUser(): List<User>
    suspend fun save(userList : List<User>)
}