package com.picpay.desafio.android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.data.api.DataState
import com.picpay.desafio.android.data.model.User
import com.picpay.desafio.android.data.usecase.GetUsers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUsers: GetUsers
) : ViewModel() {

    private val _userEvent = MutableLiveData<DataState<List<User>>>()
    val userEvent: LiveData<DataState<List<User>>> get() = _userEvent

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                _userEvent.value = getUsers.invoke()
            }catch (exception: Exception){
                Log.d("Service Error:", exception.toString())
            }
        }
    }
}