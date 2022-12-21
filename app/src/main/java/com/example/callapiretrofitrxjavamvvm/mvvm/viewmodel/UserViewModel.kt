package com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository.UserRepository
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel @Inject constructor(var userRepository: UserRepository) : ViewModel() {
    //day la Instance cho
    val listUser = MutableLiveData<List<UsersItem>?>()
    lateinit var disposable: Disposable

    fun getAllUser() {
        val response = userRepository.getAllUsers()
        response.flatMap {
            //convert tu dang lít sang object
            Observable.fromIterable(it) }.filter {
            it.id == 1
        }.doOnNext {
            Log.e("TAG", "getAllUser: $it")
        }
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
                    Log.e("ERROR", "onError: $e")

                }

                override fun onComplete() {
                    Log.e("LOG TAG", "onComplete: thanh cong")
                }

            })
//            .observeOn(AndroidSchedulers.mainThread())
    }


}
