package com.ddstar.kotlindemo.datas

import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel

/**
 * Created by DDstar on 2017/8/8.
 */
interface MainDatas :BaseData{
    interface MainDatasCallback {
        fun onDataSuc(datas: List<MainDatasModel.StoriesBean>)
        fun onDataFail(msg: String?)
    }

    fun getDatas(date: String, callback: MainDatasCallback)
}