package com.ddstar.kotlindemo.news

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.ddstar.kotlindemo.R
import com.ddstar.kotlindemo.base.BaseActivity
import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel
import com.ddstar.kotlindemo.news.detail.NewsDetailActivity
import com.ddstar.kotlindemo.utils.TimeUtils
import com.ddstar.kotlindemo.widget.KTRecyclerview
import com.ddstar.kotlindemo.widget.RcyItemClickerListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), Contacts.View, KTRecyclerview.OnKTRecyclerviewListener {


    lateinit var mainPresenter: MainPresenter
    lateinit var mAdapter: RcyAdapter
    var mPage: Int = 0
    override fun initView() {
        mAdapter = RcyAdapter(this)
        rcyview.adapter = mAdapter
        rcyview.setOnLoadmoreListener(this)
        rcyview.addOnItemTouchListener(OnItemClick(rcyview, this))
    }


    override fun initData() {
        mainPresenter = MainPresenter(this)
        mainPresenter.getDatas("latest")
    }

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun onClose() {
        mainPresenter.onCancle()
    }

    override fun onDataSuccess(datas: List<MainDatasModel.StoriesBean>) {
        val arrayList = datas as ArrayList<MainDatasModel.StoriesBean>
        if (mPage == 0) {
            var titleItem: MainDatasModel.StoriesBean = MainDatasModel.StoriesBean()
            titleItem.itemType = 99
            arrayList.add(0, titleItem)
            mAdapter.setdatas(arrayList)
        } else {
            mAdapter.addDatas(arrayList)
        }
    }

    override fun onDataFailure(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onLoadMore(page: Int) {
        mPage = page - 1
        val pageMils: Long
        if (page == 0) {
            pageMils = System.currentTimeMillis()
        } else {
            pageMils = System.currentTimeMillis() - (mPage * 24 * 60 * 60 * 1000)
        }
        mPage = page
        mainPresenter.getDatas(TimeUtils().timeTamps2Str(pageMils))
    }

    override fun onRefresh() {

    }

    class OnItemClick : RcyItemClickerListener {
        var mAdapter: RcyAdapter
        var context: Context

        constructor(view: KTRecyclerview, context: Context) : super(view) {
            mAdapter = view.adapter as RcyAdapter
            this.context = context
        }

        override fun onItemClick(vh: RecyclerView.ViewHolder?) {
            val item = mAdapter.getItem(vh!!.layoutPosition)
            val id = item.id
            var intent: Intent = Intent()
            intent.setClass(context, NewsDetailActivity().javaClass)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }

        override fun onItemLongClick(vh: RecyclerView.ViewHolder?) {

        }

    }
}

