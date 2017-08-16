package com.ddstar.kotlindemo.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.ddstar.kotlindemo.R
import com.ddstar.kotlindemo.news.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        autoIn()
    }

    fun autoIn() {
        Handler().postDelayed({
            startActivity(Intent().setClass(this, MainActivity().javaClass))
            finish()
        }, 3000)
    }
}
