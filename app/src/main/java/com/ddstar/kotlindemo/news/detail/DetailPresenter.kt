package com.ddstar.kotlindemo.news.detail

import com.ddstar.kotlindemo.datas.DetailDatas
import com.ddstar.kotlindemo.datas.dataImpl.DetailDatasImpl
import com.ddstar.kotlindemo.datas.datamodel.NewsDetailModel

/**
 * Created by DDstar on 2017/8/15.
 */
class DetailPresenter : DetailContact.Presenter, DetailDatas.OnDetailDatasCallback, DetailDatas.OnDetailDatasCssCallback {
    override fun onCssDataSuccess(data: String) {
        view.onCssDataSuccess(data)
    }

    override fun getDetailDatasCss(cssUrl: String) {
        datasource.getNewsDetailCss(cssUrl, this)
    }

    var view: DetailContact.View
    var datasource: DetailDatas
    override fun onDataSuccess(data: NewsDetailModel) {
        view.onDataSuccess(data)
    }

    override fun onDatasFail(msg: String?) {
        view.onDataFail(msg)
    }


    constructor(view: DetailContact.View) {
        this.view = view
        this.datasource = DetailDatasImpl()
    }

    override fun onCancle() {
        view.onClose()
    }

    override fun getDetailDatas(newsId: String) {
        datasource.getNewsDetail(newsId, this)
    }

}