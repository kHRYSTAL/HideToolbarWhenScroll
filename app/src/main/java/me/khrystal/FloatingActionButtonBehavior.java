package me.khrystal;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/13
 * update time:
 * email: 723526676@qq.com
 */
public class FloatingActionButtonBehavior extends FloatingActionButton.Behavior{

    private int toolbarHeight;

    public FloatingActionButtonBehavior(Context context, AttributeSet attrs){
        super();
        this.toolbarHeight = Utils.getToolbarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency)
                ||(dependency instanceof AppBarLayout);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        boolean returnValue = super.onDependentViewChanged(parent,child,dependency);
        if (dependency instanceof AppBarLayout){
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)child.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = child.getHeight()+fabBottomMargin;
            float ratio = (float)dependency.getY()/(float)toolbarHeight;
//            child.setTranslationY(-distanceToScroll*ratio);
            ViewHelper.setTranslationY(child,-distanceToScroll*ratio);
        }
        return returnValue;
    }
}
