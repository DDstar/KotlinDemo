package com.ddstar.kotlindemo.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ddstar.kotlindemo.R
import com.ddstar.kotlindemo.news.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    fun initViews() {
        et_name.hint = "请输入用户名"
        et_psd.hint = "输入密码，6-16位"
        btn_login.setOnClickListener { v ->
            Toast.makeText(this, "点击登录啦", Toast.LENGTH_SHORT).show()
            et_name.setText("点击了一下")
            v.isEnabled = false
            startActivity(Intent().setClass(this, MainActivity().javaClass))

        }
    }
}
