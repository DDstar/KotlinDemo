package com.ddstar.kotlindemo.test

import android.text.TextUtils

/**
 *
 * Created by Administrator on 2017/6/19.
 */
fun main(args: Array<String>) {
//    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
//    val jianLanbda: (Int, Int) -> Int = { x, y ->
//        if (x > y) {
//            x - y
//        } else {
//            y - x
//        }
//    }
//    println(sumLambda(10, 20))
//    println(jianLanbda(23, 32))
//    var beanty: Int = Color.RED
//    var a: Int = 10
//    a += 100
//    printStrings()
//    var result = delete(12, 6)
//    if (result) {
//        println("delete success")
//    } else {
//        println("delete fail")
//    }
//    printMore("you", "are", "a", "argly", "body")
//    var aa: Int = 10086
//    val aaa: Int = 10023
//    var a = 10023
//    val bb: String = "14022"
//    val ddd = "you are a shabi"
//    println("")
//    println("${getString("")}")
//    printAObj("shibsdsfsfsf")
//    println(ifelsefunc(30))
//    whenfunc(2)
    yinyongJust()
}


fun printStrings(): Unit/*默认的空返回类型，可以省略*/ {
    var a = "LiBai"
    println("is $a say hello")
    println("no,he is not $a")
    a = "dufu"
    println("he is ${a.replace("dufu", "a ke")}")
}

fun delete(a: Int, b: Int): Boolean {
    var fuckSuccess: (Int, Int) -> Boolean = { x, y -> x > y }//lambda
    if (fuckSuccess(a, b)) {
        return true
    }
    return false
}

fun printMore(vararg a: String) {
    for (aa in a) {
        print(aa)
    }
}

fun getString(a: String): String {
    if (TextUtils.isEmpty(a))
        return "小于0"
    if (a.toInt() < 0) {
        return "小于0"
    } else {
        return "大于或者等于0"
    }
}

fun printAObj(obj: Any) {
    if (obj is String && obj.length > 10) {//到后面的obj已经是String类型了
        println("一个长度为10 的字符")
        forCycle()
    }
}

fun forCycle() {
//    for (i in 10 downTo 1 step 3) {
//        println(i)
//    }
//    for (i in 2 until 12 step  2){
//        println(i)
//    }
//    var aaa = 100_123_456_145L
//    println(aaa is Long)
//    val arra = arrayOf(1, 2, 3, 4, 5, 6)
//    val array = IntArray(10, { i -> i * 3 })
////    for (i in array) {
////        println(i)
////    }
//    val sss: String = """
//|我
//|是
//|大
//|圣
//|你
//|知道
//|不
//|啦
//""".trimMargin("|")
//    println(sss)
    var a: Int = 140
    println(a === a) // true，值相等，对象地址相等

//经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

//虽然经过了装箱，但是值是相等的，都是100
    println(boxedA === anotherBoxedA) //  true，值相等，128 之前对象地址一样
    println(boxedA == anotherBoxedA) // true，值相等
    var ss = "aaaa"
    println("this ss string has ${ss.length} chars")
    println("this ss string is $ss")
    a = 1005
    val result = if (a > 200) "shide " else "bushide"
    println(result)
}

fun ifelsefunc(a: Int): String {
    val aaa = 100
    val bbb = 101
    if (aaa in 0..100) {
        println("$aaa 在区间内")
    }
    if (bbb in 0..100) {
        println("$bbb 在区间内")
    } else {
        println("$bbb 不在区间内")
    }


    val mm = if (a > 5) "shab" else "bush"
    return mm
}

fun whenfunc(a: Int) {
    when {
        a === 10 -> {
            println("is 10")
        }
        a == 20 -> {
            println("is 20")
        }
        else -> {
            println("not at all")
        }
    }
    when (a) {
        !in 9..100 -> println("hahhahahha")
        1 -> println("is 1 lllll")
        2, 3, 4, 5, 6 -> println("is 2 or 3 or 4 or 5 or 6 llll")
        else -> {
            val b = a + 1
            println("is $b")
        }
    }
//    forfun()
    lableFun()
}

fun forfun() {
    var aa = arrayOf(1, 2, 3, 4, 5, 7, 8, 9, 6)
    for (i in aa.indices) {
        println(aa[i])
    }
    println("**=============***")
    for ((index, value) in aa.withIndex()) {
        println(aa[index])
        println(value)
    }
    println("**=============***")
    for (item: Int in aa) {
        println(item)
    }
}

fun lableFun() {
    a@ for (i in 20..100) {
        for (j in 1..200) {
            if (j > i) break@a
            println("i am in lable item is $i")
        }
    }
}

fun yinyongJust() {
    var just = JustTest()
    just.seeYYY("aaaaa")
    just.seeBBB("bbb")
    println(just.nnn)
    JustTest.sayFuck()//伴生对象的扩展方法要用类来调用。。。。类似java的静态方法
    JustTest.saysaysat()
//    println(just.name)
//    just.gogogo()
//    JustTest(10).FuckInner().sayEatShit()
//    just.do2("fuck")
//    JustTest.FuckInner().sayEatShit()//没有inner关键字的类
//    val name = just.seriable

}

val JustTest.nnn: String//只能是val？？
    get() = "aaaa"

fun JustTest.seeYYY(name: String) {//静态解析，与成员变量一致的生命周期
    println(name)
}

fun JustTest.seeBBB(name: String) {//静态解析，与成员变量一致的生命周期
    println(name)
}

fun JustTest.Companion.sayFuck() {//伴生对象的扩展方法要用类来调用。。。。类似java的静态方法
    println("我是伴生对象的扩展方法")
}