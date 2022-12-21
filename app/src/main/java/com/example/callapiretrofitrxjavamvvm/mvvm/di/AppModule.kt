package com.example.callapiretrofitrxjavamvvm.mvvm.di

import android.app.Application
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository.UserRepository
import com.example.callapiretrofitrxjavamvvm.network.ApiService
import com.example.callapiretrofitrxjavamvvm.network.RetrofitClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    //neu tham so co application thi them
    //neu khong co thi khong tham ham nay cung duoc
    //day la demo neu repository khong co application tren constuctor thi thoi
    @Singleton
    @Provides
    fun provideAppRepository(application: Application): UserRepository{
        return UserRepository.newInstance(application)
    }
}