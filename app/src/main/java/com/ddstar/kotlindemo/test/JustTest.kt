package com.ddstar.kotlindemo.test

/**
 * Created by Administrator on 2017/7/3.
 */
open class JustTest : Base {
    override fun do3() {
        println("say fuck")
    }

    override fun do4() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun do5() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun do6() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun do1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun do2(name: String) {
        super.do2(name)
        println("fuccck $name")
    }

    init {
//        this.sex = 10000//val的成员变量可以在构造函数中初始化，也可以在init函数快中初始化
    }

//    constructor(name: String, ctx: Context) : super(ctx) {
//        //次构造器要带constutor关键字，
//        // 并且如果有主构造器一定要调用到主构造器
//        // constructor(参数等) : this(主构造的实参)
//        this.name = name
////        this.seriable = 1000000//不可变 的变量在构造函数里面初始化
//    }


    var age: Int = 2
        get() = field
        set(value) {
            if (value < 10) {
                field += 10
            } else {
                field = value
            }
        }

    override var name: String = "LiBai"//get set 的好处就是每次预处理该变量 外部直接获取该变量，而不能获取get set 方法
        get() = field.toUpperCase()//每次获取值的时候会进行此函数的操作
        set(value) {
            field = value.toLowerCase()//每次给其赋值就会执行此函数
        }
    val seriable: Long? = 10000
        get() = field

    fun gogogo() {
//        println("you a the victory")
        FuckInner().sayEatShit()
    }

    inner class FuckInner {
        fun sayEatShit() {
            println("you ate shit!!! $name")
        }
    }

    companion object {//伴生对象
    fun saysaysat(){
        println("我是伴生对象的方法")
    }
    }
}