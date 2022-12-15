package com.example.callapiretrofitrxjavamvvm.mvvm.model.UserRepository

import com.example.callapiretrofitrxjavamvvm.network.RetrofitClient

class UserRepository(private val retrofit: RetrofitClient) {
     fun getAllUsers() = retrofit.api.getAllUser()

}