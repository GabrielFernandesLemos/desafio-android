package com.picpay.desafio.android.di

import com.picpay.desafio.android.data.api.PicPayService
import com.picpay.desafio.android.data.local.UserCacheDataSource
import com.picpay.desafio.android.data.local.UserCacheDataSourceImpl
import com.picpay.desafio.android.data.remote.UserRemoteDataSource
import com.picpay.desafio.android.data.remote.UserRemoteDataSourceImpl
import com.picpay.desafio.android.domain.repository.UserRepository
import com.picpay.desafio.android.data.repository.UserRepositoryImpl
import com.picpay.desafio.android.data.local.UserDatabase
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import com.picpay.desafio.android.presentation.viewmodel.MainViewModel
import com.picpay.desafio.android.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single<PicPayService> {
        val builder = OkHttpClient.Builder()
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .connectTimeout(60L, TimeUnit.SECONDS)


        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        builder.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()
            .create(PicPayService::class.java)
    }

    single { UserDatabase.createDataBase(androidApplication()) }
    single {  get<UserDatabase>().userDao() }
    factory<UserCacheDataSource> { UserCacheDataSourceImpl(userDao = get()) }
    factory<UserRemoteDataSource> { UserRemoteDataSourceImpl(api = get()) }
    factory<UserRepository> { UserRepositoryImpl(remoteDataSource = get(), cacheDataSource = get()) }
    factory { GetUsersUseCase(userRepository = get()) }

    viewModel { MainViewModel(getUsersUseCase = get()) }
}