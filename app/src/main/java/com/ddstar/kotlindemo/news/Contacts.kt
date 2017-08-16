package com.ddstar.kotlindemo.news

import com.ddstar.kotlindemo.datas.BasePresenter
import com.ddstar.kotlindemo.datas.BaseView
import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel

/**
 * Created by DDstar on 2017/8/8.
 */
interface Contacts {
    interface View :BaseView{
        fun onDataSuccess(datas: List<MainDatasModel.StoriesBean>)
        fun onDataFailure(msg: String?)
    }

    interface Presenter:BasePresenter{
        fun getDatas(date: String)//日期 2017-8-3 -> 20170803 最新 latest
    }
}