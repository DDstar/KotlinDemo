package com.ddstar.kotlindemo.datas.dataImpl

import com.ddstar.kotlindemo.base.Urls
import com.ddstar.kotlindemo.datas.MainDatas
import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel
import com.ddstar.kotlindemo.utils.TimeUtils
import com.google.gson.Gson
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.AbsCallback
import okhttp3.Call
import okhttp3.Response

/**
 * Created by DDstar on 2017/8/8.
 */
class MainDatasImpl : MainDatas {
    lateinit var mInstance: MainDatasImpl


    fun getInstance(): MainDatasImpl {
        if (mInstance === null) {
            mInstance = MainDatasImpl()
        }
        return mInstance
    }

    override fun cancle() {

        OkGo.getInstance().cancelTag(this)
    }

    override fun getDatas(date: String, callback: MainDatas.MainDatasCallback) {
        var dateNew = date
        if (!"latest".equals(date)) {
            dateNew = "before/" + date
        }
        OkGo.get(Urls().MAIN_URL + dateNew)
                .tag(this)
                .execute(object : AbsCallback<MainDatasModel>() {
                    override fun onSuccess(datasObj: MainDatasModel, call: Call, response: okhttp3.Response) {
                        var titleItem: MainDatasModel.StoriesBean = MainDatasModel.StoriesBean()
                        titleItem.title = TimeUtils().dateFormat(datasObj.date)
                        titleItem.itemType = 100
                        val stories = datasObj.stories
                        stories.add(0, titleItem)
                        callback.onDataSuc(stories)
                    }

                    @Throws(Exception::class)
                    override fun convertSuccess(response: okhttp3.Response): MainDatasModel {
                        return Gson().fromJson(response.body().string(), MainDatasModel::class.java)
                    }

                    override fun onError(call: Call?, response: Response?, e: java.lang.Exception?) {
                        callback.onDataFail(e?.message)
                    }
                })
    }
}