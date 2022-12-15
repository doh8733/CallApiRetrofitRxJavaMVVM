package com.example.callapiretrofitrxjavamvvm.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callapiretrofitrxjavamvvm.R
import com.example.callapiretrofitrxjavamvvm.mvp.presenter.listener.CallApiInterface
import com.example.callapiretrofitrxjavamvvm.mvp.presenter.CallApiPresenter
import com.example.callapiretrofitrxjavamvvm.mvp.view.adapter.UserAdapter
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem

class MainViewMVPActivity : AppCompatActivity(), CallApiInterface {

    private val rcvUser: RecyclerView by lazy { findViewById<RecyclerView>(R.id.rcvUser) }
    private var listUser = listOf<UsersItem>()
    private lateinit var userAdapter: UserAdapter

    private lateinit var callApiPresenter: CallApiPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_mvpactivity)
        userAdapter = UserAdapter()
        callApiPresenter = CallApiPresenter(this)
        callApiPresenter.getApiFromServer()
    }



    override fun callError(e: Throwable) {
        Log.e("TAG", "callError: $e", )

    }

    override fun onNextData(list: List<UsersItem>) {
        listUser = list
        Log.e("LOG LIST", "onNextData: $list", )
    }
    override fun callSuccess() {
        rcvUser.layoutManager = LinearLayoutManager(this)
        userAdapter.listUSer = listUser
        rcvUser.adapter = userAdapter
    }
    override fun onDestroy() {
        super.onDestroy()
        callApiPresenter.mDisposable.dispose()
    }
}