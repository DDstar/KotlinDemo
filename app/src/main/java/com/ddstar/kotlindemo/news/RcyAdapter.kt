package com.ddstar.kotlindemo.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ddstar.kotlindemo.R
import com.ddstar.kotlindemo.datas.datamodel.MainDatasModel

/**
 * Created by DDstar on 2017/8/8.
 */
class RcyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    val ITEM_TYPE_TITLE: Int = 100
    val ITEM_TYPE_ITEM: Int = 101
    val ITEM_TYPE_BANNER: Int = 99
    val mContext: Context

    constructor(context: Context) {
        mContext = context
    }

    var datas: ArrayList<MainDatasModel.StoriesBean> = ArrayList()
    fun setdatas(datas: ArrayList<MainDatasModel.StoriesBean>) {
        if (this.datas === null) {
            this.datas = ArrayList()
        } else {
            this.datas.clear()
        }
        addDatas(datas)
    }

    fun addDatas(datas: List<MainDatasModel.StoriesBean>) {
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): MainDatasModel.StoriesBean {
        return datas.get(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val storiesBean = datas.get(position)
        if (getItemViewType(position) == ITEM_TYPE_BANNER) {

        } else if (getItemViewType(position) == ITEM_TYPE_TITLE) {
            val vhHeader = holder as VHHeader
            vhHeader.headText.text = storiesBean.title
        } else {
            val vhItem = holder as VHItem
            vhItem.headText.text = storiesBean.title
            Glide.with(mContext)
                    .load(storiesBean.images.get(0))
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .into(vhItem.pics)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_TYPE_BANNER) {
            return VHBanner(LayoutInflater.from(mContext)?.inflate(R.layout.layout_news_banner, parent, false)!!)
        } else if (viewType == ITEM_TYPE_TITLE) {
            return VHHeader(LayoutInflater.from(mContext)?.inflate(R.layout.layout_news_head, parent, false)!!)
        } else {
            return VHItem(LayoutInflater.from(mContext)?.inflate(R.layout.layout_news_item, parent, false)!!)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun getItemViewType(position: Int): Int {
        return datas.get(position).itemType
    }

    class VHBanner : RecyclerView.ViewHolder {
        var container: View

        constructor(view: View) : super(view) {
            container = view.findViewById(R.id.container)
        }
    }

    class VHHeader : RecyclerView.ViewHolder {
        var headText: TextView

        constructor(view: View) : super(view) {
            headText = view.findViewById(R.id.title) as TextView
        }
    }

    class VHItem : RecyclerView.ViewHolder {
        var headText: TextView
        var pics: ImageView

        constructor(view: View) : super(view) {
            headText = view.findViewById(R.id.tv_content) as TextView
            pics = view.findViewById(R.id.imageView) as ImageView
        }
    }
}