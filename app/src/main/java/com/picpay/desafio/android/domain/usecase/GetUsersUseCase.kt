package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.domain.model.EmptyException
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.repository.UserRepository

class GetUsersUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<User> {
        val users = userRepository.getUsers()
        if (users.isEmpty()) throw EmptyException()
        return users
    }
}