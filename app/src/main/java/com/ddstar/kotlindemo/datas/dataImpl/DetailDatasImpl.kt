package com.ddstar.kotlindemo.datas.dataImpl

import android.text.TextUtils
import com.ddstar.kotlindemo.base.Urls
import com.ddstar.kotlindemo.datas.DetailDatas
import com.ddstar.kotlindemo.datas.datamodel.NewsDetailModel
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.AbsCallback
import okhttp3.Call
import okhttp3.Response
import org.json.JSONObject
import java.lang.Exception

/**
 * Created by DDstar on 2017/8/15.
 */
class DetailDatasImpl : DetailDatas {
    var isLoading: Boolean = false
    override fun getNewsDetailCss(cssUrl: String, callback: DetailDatas.OnDetailDatasCssCallback) {
        OkGo.get(cssUrl)
                .tag(this)
                .execute(object : AbsCallback<String>() {
                    override fun onSuccess(t: String?, call: Call?, response: Response?) {
                        if (t == null || TextUtils.isEmpty(t)) {
                            callback.onDatasFail("数据异常")
                            return
                        }
                        callback.onCssDataSuccess(t!!)
                    }

                    override fun convertSuccess(response: Response?): String {
                        return response?.body()?.string()!!
                    }

                    override fun onError(call: Call?, response: Response?, e: Exception?) {
                        super.onError(call, response, e)
                        callback.onDatasFail(e?.message)
                    }
                })
    }


    override fun getNewsDetail(newsId: String, callback: DetailDatas.OnDetailDatasCallback) {
        OkGo.get(Urls().MAIN_URL + newsId)
                .tag(this)
                .execute(object : AbsCallback<NewsDetailModel>() {
                    override fun convertSuccess(response: Response?): NewsDetailModel {
                        var dataModel: NewsDetailModel = NewsDetailModel()
                        var resultData: String = response?.body()?.string()!!
                        var dataObj: JSONObject = JSONObject(resultData)
                        val dataBody = dataObj.optString("body")
                        val cssArr = dataObj.optJSONArray("css")
                        var cssDatas: ArrayList<String> = ArrayList()
                        if (cssArr != null && cssArr.length() > 0)
                            cssDatas.add(cssArr.optString(0))
                        dataModel.body = dataBody
                        dataModel.css = cssDatas
                        dataModel.image = dataObj.optString("image")
                        dataModel.title = dataObj.optString("title")
                        dataModel.share_url = dataObj.optString("share_url")
                        if (resultData.contains("image_source"))
                            dataModel.image_source = dataObj.optString("image_source")
                        return dataModel
                    }

                    override fun onSuccess(t: NewsDetailModel?, call: Call?, response: Response?) {
                        callback.onDataSuccess(t!!)
                    }

                    override fun onError(call: Call?, response: Response?, e: Exception?) {
                        super.onError(call, response, e)
                        callback.onDatasFail(e?.message)
                    }
                })
    }

    override fun cancle() {
        OkGo.getInstance().cancelTag(this)
    }
}