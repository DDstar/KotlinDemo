package com.ddstar.kotlindemo.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by DDstar on 2017/8/14.
 */
class TimeUtils {
    fun timeTamps2Str(timeMils: Long): String {
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        return dateFormat.format(timeMils)
    }

    /**
     * 20170814--》8月14日 星期一
     */
    fun dateFormat(timeStr: String): String {
        val dateFormatOld = SimpleDateFormat("yyyyMMdd")
        val date = dateFormatOld.parse(timeStr)
        val dateFormat = SimpleDateFormat("MM月dd日")
        val calendar = Calendar.getInstance()
        calendar.time = date
        Log.e("dateFormat", "timeStr===" + timeStr)
        val week = findWeek(calendar.get(Calendar.DAY_OF_WEEK))

        return dateFormat.format(date) + "  星期" + week
    }

    fun findWeek(num: Int): String {
        var weekDay: String = ""
        Log.e("findWeek", "www==" + num)
        when (num) {
            1 -> weekDay = "日"
            2 -> weekDay = "一"
            3 -> weekDay = "二"
            4 -> weekDay = "三"
            5 -> weekDay = "四"
            6 -> weekDay = "五"
            7 -> weekDay = "六"
        }
        return weekDay
    }
}