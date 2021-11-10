package com.picpay.desafio.android.presentation.viewmodel

import com.picpay.desafio.android.domain.model.User

data class ViewState(
    val userList : List<User> = emptyList(),
    val isEmptyState : Boolean,
    val isLoading : Boolean,
)