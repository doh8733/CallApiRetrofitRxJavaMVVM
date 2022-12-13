package com.example.callapiretrofitrxjavamvvm.UserRepository

import com.example.callapiretrofitrxjavamvvm.RetrofitClient
import retrofit2.Retrofit

class UserRepository(private val retrofit: RetrofitClient) {
     fun getAllUsers() = retrofit.api.getAllUser()

}