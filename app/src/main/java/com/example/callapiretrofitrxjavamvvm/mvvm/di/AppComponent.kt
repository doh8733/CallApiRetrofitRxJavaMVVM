package com.example.callapiretrofitrxjavamvvm.mvvm.di

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.callapiretrofitrxjavamvvm.mvvm.view.MainActivity
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.UserViewModel
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.factory.UserViewModelFactory
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository.UserRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun getUserViewModel(): UserViewModel
    fun injectAtv(activity: MainActivity)


    @Component.Builder
    interface Builder{
        @BindsInstance
        fun createApplication(application: Application):Builder

        fun build():AppComponent
    }
}