package com.ddstar.kotlindemo.widget;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class RcyItemClickerListener extends RecyclerView.SimpleOnItemTouchListener {

    private GestureDetectorCompat mGestureDetectorCompat;
    private RecyclerView mRecyclerView;

    public RcyItemClickerListener(final RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new GestureDetector.SimpleOnGestureListener() {
            //接触到的屏幕的坐标返回给 MotionEvent
            //通过MotionEvent获取到当前接触到的屏幕的坐标
            //Recyvlerview根据坐标获取到当前的childview
            //再根据childview获取到当前childView的holder，然后就可以处理了
            @Override
            public void onLongPress(MotionEvent e) {//长按

                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(childView);
                    onItemLongClick(viewHolder);
                }
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {//单击
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView != null) {
                    RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(childView);
                    onItemClick(viewHolder);
                }
                return true;
            }
        });

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    public abstract void onItemClick(RecyclerView.ViewHolder vh);

    public abstract void onItemLongClick(RecyclerView.ViewHolder vh);
}