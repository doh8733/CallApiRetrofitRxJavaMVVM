package com.example.callapiretrofitrxjavamvvm

import android.app.Application
import com.example.callapiretrofitrxjavamvvm.mvvm.di.AppComponent
import com.example.callapiretrofitrxjavamvvm.mvvm.di.DaggerAppComponent

class MyApp: Application() {
    lateinit var component: AppComponent
    //đây gọi là scope làm cách này sẽ giúp repository sẽ chỉ khởi tạo một lần
    // trong xuyên suốt quá trình thực hiện chạy ứng dụng giúp tránh việc tràn bộ nhớ và nâng cao hiệu năng
    //NHỚ KHAI BÁO CLASS NÀY TRONG MANIFEST
    override fun onCreate() {
        super.onCreate()
       component = DaggerAppComponent.builder().createApplication(this).build()

    }
}