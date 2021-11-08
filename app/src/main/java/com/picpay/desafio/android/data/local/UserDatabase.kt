package com.picpay.desafio.android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.model.UserEntity
import com.picpay.desafio.android.utils.Constants.DATABASE_NAME

@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        fun createDataBase(context: Context): UserDatabase {
            return Room
                .databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    DATABASE_NAME
                )
                .build()
        }
    }
}
