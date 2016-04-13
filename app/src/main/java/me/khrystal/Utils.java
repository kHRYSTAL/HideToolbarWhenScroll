package me.khrystal;

import android.content.Context;
import android.content.res.TypedArray;

import me.khrystal.htb.R;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/13
 * update time:
 * email: 723526676@qq.com
 */
public class Utils {

    public static final int getToolbarHeight(Context context){
        final TypedArray attributes =
                context.getTheme().obtainStyledAttributes(new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int)attributes.getDimension(0,0);
        attributes.recycle();
        return toolbarHeight;
    }

    public static final int getTabsHeight(Context context){
        return (int) context.getResources().getDimension(R.dimen.tabs_height);
    }
}
