package com.ddstar.kotlindemo.datas

import com.ddstar.kotlindemo.datas.datamodel.NewsDetailModel

/**
 * Created by DDstar on 2017/8/15.
 */
interface DetailDatas : BaseData {
    interface OnDetailDatasCallback {
        fun onDataSuccess(data: NewsDetailModel)
        fun onDatasFail(msg: String?)
    }

    interface OnDetailDatasCssCallback {
        fun onCssDataSuccess(data: String)
        fun onDatasFail(msg: String?)
    }

    fun getNewsDetail(newsId: String, callback: OnDetailDatasCallback)
    fun getNewsDetailCss(cssUrl: String, callback: OnDetailDatasCssCallback)
}