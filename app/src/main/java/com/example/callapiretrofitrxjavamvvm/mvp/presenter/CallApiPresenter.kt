package com.example.callapiretrofitrxjavamvvm.mvp.presenter

import com.example.callapiretrofitrxjavamvvm.mvp.presenter.listener.CallApiInterface
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem
import com.example.callapiretrofitrxjavamvvm.network.RetrofitClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CallApiPresenter(private var callApiInterface: CallApiInterface) {
     lateinit var mDisposable :Disposable
    private var listUser = listOf<UsersItem>()
    fun getApiFromServer(){
       val response = RetrofitClient.api.getAllUser()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<List<UsersItem>>{
                override fun onSubscribe(d: Disposable) {
                    mDisposable = d
                }

                override fun onNext(t: List<UsersItem>) {
                    callApiInterface.onNextData(t)

                }

                override fun onError(e: Throwable) {
                    callApiInterface.callError(e)
                }

                override fun onComplete() {
                    callApiInterface.callSuccess()
                }
            })
    }
}