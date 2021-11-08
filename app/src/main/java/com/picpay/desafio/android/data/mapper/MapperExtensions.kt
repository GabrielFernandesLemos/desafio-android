package com.picpay.desafio.android.data.mapper

import com.picpay.desafio.android.data.model.UserEntity
import com.picpay.desafio.android.data.model.UserResponse
import com.picpay.desafio.android.domain.model.User

fun UserEntity.toDomain() = User(
    id = this.id,
    name = this.name,
    username = this.username,
    img = this.img
)

fun UserResponse.toDomain() = User(
    id = this.id,
    name = this.name,
    username = this.username,
    img = this.img
)

fun User.toEntity() = UserEntity(
    id = this.id,
    name = this.name,
    username = this.username,
    img = this.img
)
