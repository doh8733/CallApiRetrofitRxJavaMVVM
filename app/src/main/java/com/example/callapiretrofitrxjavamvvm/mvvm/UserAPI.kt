package com.example.callapiretrofitrxjavamvvm.mvvm

import com.example.callapiretrofitrxjavamvvm.network.ApiService

abstract class UserAPI {
    abstract fun getUserAPI():ApiService
    companion object
}