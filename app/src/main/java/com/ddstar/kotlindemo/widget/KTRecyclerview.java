package com.ddstar.kotlindemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by DDstar on 2017/8/14.
 */

public class KTRecyclerview extends RecyclerView {
    private int lastVisibleItem;//最后一个可见的position
    private int page;
    private OnKTRecyclerviewListener onKTRecyclerviewListener;

    public KTRecyclerview(Context context) {
        this(context, null);
    }

    public KTRecyclerview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KTRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.setLayoutManager(new LinearLayoutManager(context));
        this.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.getAdapter() == null)
                    return;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == recyclerView.getAdapter().getItemCount()) {//已经滑到最底而且已经停止滑动
                    if (onKTRecyclerviewListener != null) {
                        page++;
                        onKTRecyclerviewListener.onLoadMore(page);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getLayoutManager() == null)
                    return;
                lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
            }
        });
        this.addOnItemTouchListener(new SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return super.onInterceptTouchEvent(rv, e);
            }
        });
    }

    public void setOnLoadmoreListener(OnKTRecyclerviewListener onKTRecyclerviewListener) {
        this.onKTRecyclerviewListener = onKTRecyclerviewListener;
    }

    public interface OnKTRecyclerviewListener {
        void onLoadMore(int page);

        void onRefresh();
    }
}
