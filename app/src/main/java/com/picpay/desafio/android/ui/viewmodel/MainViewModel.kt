package com.picpay.desafio.android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.android.ui.entity.User
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _userEvent = MutableLiveData<List<User>>()
    val userEvent: LiveData<List<User>> get() = _userEvent

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                _userEvent.value = repository.getUsers()
            }catch (e: Exception){
                Log.d("Service Error:", e.toString())
            }
        }
    }
}