package com.ddstar.kotlindemo.news.detail

import com.ddstar.kotlindemo.datas.BasePresenter
import com.ddstar.kotlindemo.datas.BaseView
import com.ddstar.kotlindemo.datas.datamodel.NewsDetailModel

/**
 * Created by DDstar on 2017/8/15.
 */
interface DetailContact {
    interface View : BaseView {
        fun onDataSuccess(data: NewsDetailModel)
        fun onCssDataSuccess(cssData: String)
        fun onDataFail(msg: String?)
    }

    interface Presenter : BasePresenter {
        fun getDetailDatas(newsId: String)
        fun getDetailDatasCss(cssUrl: String)
    }
}