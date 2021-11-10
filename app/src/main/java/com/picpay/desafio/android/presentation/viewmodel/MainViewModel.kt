package com.picpay.desafio.android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.model.EmptyException
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>()
    val state: LiveData<ViewState> = _state

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            runCatching {
                _state.value = ViewState(isLoading = true, isEmptyState = false)
                getUsersUseCase()
            }.onSuccess { users ->
                _state.value = ViewState(userList = users, isEmptyState = false, isLoading = false)
            }.onFailure { throwable ->
                when (throwable) {
                    is EmptyException -> {
                        ViewState(isEmptyState = true, isLoading = false)
                    }
                }
            }
        }
    }
}