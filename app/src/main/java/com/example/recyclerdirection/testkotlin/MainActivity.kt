package com.example.recyclerdirection.testkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*属性*/
        main_text.text = ("PowerFullKotlin")
        var bean = KotlinBean()
        bean.name = "a"
        main_text.text = (bean.name)

        /*函数使用*/
        fun printLength(obj: Any) {
            println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
        }
        printLength("Incomprehensibilities")
        printLength(1000)
        printLength(listOf(Any()))

/*模板使用*/
        var a = 1
        // 使用变量名作为模板:
        val s1 = "a is $a"

        a = 2
        // 使用表达式作为模板:
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        println(s2)

        Log.e("===", s2)
    }

    /**
     *  定义一个函数
     */
    fun sum(a: Int, b: Int): Int {
        // 定义局部变量
        val c: Int = 1 // 立即初始化
        val b = 2  //推导出Int型

        return a + b
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // obj 将会在这个分支中自动转换为 String 类型
            return obj.length
        }

        // obj 在种类检查外仍然是 Any 类型
        return null
    }

    fun demo(lists: ArrayList<Int>) {
        val list = ArrayList<Int>()
        for (item in lists)
            list.add(item)
        for (i in 0..lists.size - 1)
            list[i] = lists[i]
    }

    fun describe(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

}
