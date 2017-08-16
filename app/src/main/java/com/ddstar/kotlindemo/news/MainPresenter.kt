package com.ddstar.kotlindemo.news

import android.util.Log
import com.ddstar.kotlindemo.datas.MainDatas
import com.ddstar.kotlindemo.datas.dataImpl.MainDatasImpl
import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel

/**
 * Created by DDstar on 2017/8/8.
 */
class MainPresenter : Contacts.Presenter, MainDatas.MainDatasCallback {
    override fun onCancle() {
        datasource.cancle()
    }

    override fun onDataSuc(datas: List<MainDatasModel.StoriesBean>) {
        view.onDataSuccess(datas)
    }

    override fun onDataFail(msg: String?) {
        view.onDataFailure(msg)
    }

    var view: Contacts.View
    var datasource: MainDatas

    constructor(view: Contacts.View) {
        this.view = view
        datasource = MainDatasImpl()
    }

    override fun getDatas(date: String) {
        Log.e("date", date)
        datasource.getDatas(date, this)
    }

}