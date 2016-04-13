package me.khrystal.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/13
 * update time:
 * email: 723526676@qq.com
 */
public abstract class FirstScrollListener extends RecyclerView.OnScrollListener{
    public static final int HIDE_THRESHOLD = 20;

    private int mScrolledDistance = 0;
    private boolean mControlsVisible = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int firstVisibleItem = ((LinearLayoutManager)
                recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

        if (firstVisibleItem==0){
            if (!mControlsVisible){
                onShow();
                mControlsVisible=true;
            }
        }else {
            if (mScrolledDistance>HIDE_THRESHOLD && mControlsVisible){
                onHide();
                mControlsVisible = false;
                mScrolledDistance = 0;
            }else if (mScrolledDistance < -HIDE_THRESHOLD && !mControlsVisible){
                onShow();
                mControlsVisible = true;
                mScrolledDistance = 0;
            }
        }
        if( (mControlsVisible && dy>0)||(!mControlsVisible && dy<0)){
            mScrolledDistance += dy;
        }
    }

    public abstract void onShow();
    public abstract void onHide();
}
