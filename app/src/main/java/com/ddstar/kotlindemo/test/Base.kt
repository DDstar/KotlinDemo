package com.ddstar.kotlindemo.test

/**
 * Created by Administrator on 2017/7/17.
 */
interface Base {
    var name:String //name 属性, 抽象的
    abstract fun do1()
    abstract fun do3()
    abstract fun do4()
    abstract fun do5()
    abstract fun do6()
    open fun do2(name: String) {
        println(name)
    }
}