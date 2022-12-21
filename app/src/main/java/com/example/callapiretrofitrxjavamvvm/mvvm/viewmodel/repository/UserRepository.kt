package com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository

import android.app.Application
import com.example.callapiretrofitrxjavamvvm.network.RetrofitClient
import retrofit2.Retrofit
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(application: Application) {
    companion object {
        private var instance: UserRepository? = null
        fun newInstance(application: Application): UserRepository {
            if (instance == null) {
                instance = UserRepository(application = application)
            }
            return instance!!
        }
    }
    fun getAllUsers() = RetrofitClient.api.getAllUser()
}