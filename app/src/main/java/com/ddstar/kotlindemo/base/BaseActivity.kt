package com.ddstar.kotlindemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ddstar.kotlindemo.datas.BaseView

open abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initData()
        initView()
    }

    abstract fun initView()//初始化各种View

    abstract fun initData()//获取数据

    abstract fun setLayout(): Int//初始化布局

    override fun onDestroy() {
        super.onDestroy()
        onClose()
    }
}
