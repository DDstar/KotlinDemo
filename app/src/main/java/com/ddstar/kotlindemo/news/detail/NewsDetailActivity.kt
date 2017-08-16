package com.ddstar.kotlindemo.news.detail

import android.webkit.WebSettings
import com.bumptech.glide.Glide
import com.ddstar.kotlindemo.R
import com.ddstar.kotlindemo.base.BaseActivity
import com.ddstar.kotlindemo.datas.datamodel.NewsDetailModel
import kotlinx.android.synthetic.main.activity_news_detail.*

/**
 * @author DDstar
 */
class NewsDetailActivity : BaseActivity(), DetailContact.View {
    lateinit var data: NewsDetailModel
    override fun onCssDataSuccess(cssData: String) {
//        web_detail.setWebViewClient(WebClient(cssData))
    }

    lateinit var mPresenter: DetailContact.Presenter
    override fun initView() {
        val webSettings = web_detail.settings
        web_detail.fitsSystemWindows = true
        webSettings.javaScriptEnabled = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
    }

    override fun initData() {
        val newsId = intent.getStringExtra("id")
        mPresenter = DetailPresenter(this)
        mPresenter.getDetailDatas(newsId)
    }

    override fun setLayout(): Int {
        return R.layout.activity_news_detail
    }

    override fun onClose() {
//        mPresenter.onCancle()
    }

    override fun onDataSuccess(data: NewsDetailModel) {
        this.data = data
//        web_detail.loadDataWithBaseURL(null, data.body, "text/html", "utf-8", null)
        web_detail.loadUrl(data.share_url)
        mPresenter.getDetailDatasCss(data.css.get(0))
        Glide.with(this)
                .load(data.image)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(image_heade)
        tv_title.text = data.title
        tv_source.text = data.image_source
    }

    override fun onDataFail(msg: String?) {

    }
}
