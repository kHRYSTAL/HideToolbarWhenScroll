package me.khrystal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.khrystal.holder.SimpleHeader;
import me.khrystal.holder.SimpleViewHolder;
import me.khrystal.htb.R;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/4/13
 * update time:
 * email: 723526676@qq.com
 */
public class FirstAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;
    private List<String> mItemList;

    public FirstAdapter(List<String> itemList){
        mItemList = itemList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM){
            final View view = LayoutInflater.from(context)
                    .inflate(R.layout.list_item,parent,false);
            return SimpleViewHolder.newInstance(view);
        }else if (viewType == TYPE_HEADER){
            final View view = LayoutInflater.from(context)
                    .inflate(R.layout.header,parent,false);
            return new SimpleHeader(view);
        }
        throw new RuntimeException("no type matched");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //is not header
        if (position!=0){
            SimpleViewHolder simpleViewHolder = (SimpleViewHolder)holder;
            String itemText = mItemList.get(position-1);//header has first position
            simpleViewHolder.setItemText(itemText);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        //1 is header
        return mItemList == null ? 1 : mItemList.size() + 1;
    }
}
