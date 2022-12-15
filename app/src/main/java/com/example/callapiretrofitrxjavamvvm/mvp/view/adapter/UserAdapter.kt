package com.example.callapiretrofitrxjavamvvm.mvp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.callapiretrofitrxjavamvvm.R
import com.example.callapiretrofitrxjavamvvm.mvp.model.User
import com.example.callapiretrofitrxjavamvvm.mvvm.model.UsersItem

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var listUSer = listOf<UsersItem>()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    class ViewHolder(view :View):RecyclerView.ViewHolder(view) {
        private val tvId: TextView by lazy { view.findViewById<TextView>(R.id.tvId) }
        private val tvUserId: TextView by lazy { view.findViewById<TextView>(R.id.tvUserId) }
        private val tvTitle: TextView by lazy { view.findViewById<TextView>(R.id.tvTitle) }
        fun onBindView(user: UsersItem){
            tvId.text = user.id.toString()
            tvUserId.text = user.userId.toString()
            tvTitle.text = user.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_adapter,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindView(listUSer[position])
    }

    override fun getItemCount(): Int = listUSer.size

}