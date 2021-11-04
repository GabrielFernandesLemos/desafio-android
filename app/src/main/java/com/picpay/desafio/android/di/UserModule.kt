package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.remote.UserRemoteDataSource
import com.picpay.desafio.android.data.remote.UserRemoteDataSourceImpl
import com.picpay.desafio.android.data.repository.UserRepository
import com.picpay.desafio.android.data.repository.UserRepositoryImpl
import com.picpay.desafio.android.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    factory<UserRemoteDataSource> { UserRemoteDataSourceImpl(api = get()) }
    factory<UserRepository> { UserRepositoryImpl(dataSource = get()) }

    viewModel { MainViewModel(repository = get()) }
}