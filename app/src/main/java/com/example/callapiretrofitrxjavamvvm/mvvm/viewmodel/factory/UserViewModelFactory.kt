package com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UserRepository.UserRepository
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.UserViewModel

class UserViewModelFactory(val repository: UserRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            UserViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}