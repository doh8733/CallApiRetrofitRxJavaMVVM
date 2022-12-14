package com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository.UserRepository
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.UserViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory @Inject constructor(private val repository: UserRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            UserViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}