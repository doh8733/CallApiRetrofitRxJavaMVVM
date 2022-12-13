package com.example.callapiretrofitrxjavamvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.callapiretrofitrxjavamvvm.UserRepository.UserRepository
import com.example.callapiretrofitrxjavamvvm.UsersItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class UserViewModel(private val userRepository: UserRepository) :ViewModel() {
     val listUser = MutableLiveData<List<UsersItem>>()
    private lateinit var disposable:Disposable

     fun getAllUser(){
        val response = userRepository.getAllUsers()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<UsersItem>> {
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(t: List<UsersItem>) {
                    listUser.postValue(t)
                }

                override fun onError(e: Throwable) {
                    listUser.postValue(null)
                    Log.e("ERROR", "onError: $e",)

                }

                override fun onComplete() {
                    Log.e("LOG TAG", "onComplete: thanh cong",)
                }

            })
//            .observeOn(AndroidSchedulers.mainThread())
    }


    class UserViewModelFactory (val repository: UserRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if(modelClass.isAssignableFrom(UserViewModel::class.java)){
                UserViewModel(this.repository) as T
            }else{
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }

}
