package com.example.callapiretrofitrxjavamvvm.mvp.presenter.listener

import com.example.callapiretrofitrxjavamvvm.mvp.model.User
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem

interface CallApiInterface {
    fun callSuccess()
    fun callError(e :Throwable)
    fun onNextData(list: List<UsersItem>)
}