package com.picpay.desafio.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.android.ui.entity.User
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _userEvent = MutableLiveData<User>()
    val userEvent: LiveData<User> get() = _userEvent

    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            repository.getUsers()
        }
    }
}