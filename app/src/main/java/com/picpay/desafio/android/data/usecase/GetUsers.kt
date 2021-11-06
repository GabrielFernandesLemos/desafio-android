package com.picpay.desafio.android.data.usecase

import com.picpay.desafio.android.data.api.DataState
import com.picpay.desafio.android.data.api.parseResponse
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.repository.UserRepository

class GetUsers
constructor(
    private val repository: UserRepository
) : BaseUseCase.Empty<DataState<List<User>>> {

    override suspend fun invoke(): DataState<List<User>> {
        return when (val response = repository.getUsers().parseResponse()) {
            is DataState.OnSuccess -> response.data?.let {
                DataState.OnSuccess(it.map { value ->
                    User(
                        id = value.name,
                        name = value.name,
                        img = value.img,
                        username = value.username
                    )
                })
            } ?: DataState.OnException(Exception("User list is empty!"))

            is DataState.OnError -> DataState.OnError(response.errorBody, response.code)

            is DataState.OnException -> DataState.OnException(response.e)
        }
    }
}