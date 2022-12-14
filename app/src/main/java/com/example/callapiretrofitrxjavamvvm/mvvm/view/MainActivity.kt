package com.example.callapiretrofitrxjavamvvm.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.callapiretrofitrxjavamvvm.MyApp
import com.example.callapiretrofitrxjavamvvm.R
import com.example.callapiretrofitrxjavamvvm.mvvm.di.AppComponent
import com.example.callapiretrofitrxjavamvvm.network.RetrofitClient
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.repository.UserRepository
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.UserViewModel
import com.example.callapiretrofitrxjavamvvm.mvvm.viewmodel.factory.UserViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val edtIdUser: EditText by lazy { findViewById<EditText>(R.id.edtIdUser) }
    private val edtId: EditText by lazy { findViewById<EditText>(R.id.edtId) }
    private val btnLogin: Button by lazy { findViewById<Button>(R.id.btnLogin) }
    private val tvUser: TextView by lazy { findViewById<TextView>(R.id.tvUser) }

//    private val viewmodel :UserViewModel by viewModels {
//        getA
//    }
    private val viewmodel: UserViewModel by lazy {
        ViewModelProvider(
            this, UserViewModelFactory(
                UserRepository(application)
            )
        )[UserViewModel::class.java]
    }
    private var isHashUser = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = (application as MyApp).component
        component.injectAtv(this)
        // https://jsonplaceholder.typicode.com/posts
        btnLogin.setOnClickListener {
            viewmodel.getAllUser()
            val id = edtId.text.toString()
            val idUser = edtIdUser.text.toString()
            viewmodel.listUser.observe(this) {
                Log.e("TAG", "onCreate: $it")
                tvUser.text = "$it"
                if (it != null) {
                    for (i in it) {
                        if (id.equals(i.id.toString(), true) && idUser.equals(
                                i.userId.toString(),
                                true
                            )
                        ) {
                            isHashUser = true
                        }
                    }
                }
                if (isHashUser) {
                    Toast.makeText(this@MainActivity, R.string.login_success, Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this, MainActivity2::class.java))
                }
            }
        }
    }
}