package com.example.callapiretrofitrxjavamvvm.network

import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getAllUser() : Observable<List<UsersItem>>

}