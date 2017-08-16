package com.ddstar.kotlindemo.base

import android.app.Application
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import java.util.logging.Level


/**
 * Created by DDstar on 2017/8/4.
 */
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initOkGo()
    }

    private fun initOkGo() {
        OkGo.getInstance()
                .debug(packageName, Level.INFO, true)
                .setReadTimeOut(30000)
                .setConnectTimeout(30000)
                .setWriteTimeOut(60000)
                .setCacheMode(CacheMode.NO_CACHE)
                .cacheTime = CacheEntity.CACHE_NEVER_EXPIRE
    }
}