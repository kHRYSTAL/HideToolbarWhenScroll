package me.khrystal.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.khrystal.htb.R;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/13
 * update time:
 * email: 723526676@qq.com
 */
public class SimpleViewHolder extends RecyclerView.ViewHolder{

    private final TextView mItemTextView;

    public SimpleViewHolder(final View itemView,TextView itemTextView) {
        super(itemView);
        mItemTextView = itemTextView;
    }

    public static SimpleViewHolder newInstance(View parent){
        TextView itemTextView = (TextView)parent.findViewById(R.id.item_text);
        return new SimpleViewHolder(parent,itemTextView);
    }

    public void setItemText(CharSequence text){
        mItemTextView.setText(text);
    }
}
