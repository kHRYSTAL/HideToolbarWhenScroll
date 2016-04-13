package me.khrystal.htb;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.adapter.FirstAdapter;
import me.khrystal.listener.FirstScrollListener;

public class SecondActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initToolBar();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setAdapter(new FirstAdapter(getList()));
        mRecyclerView.addOnScrollListener(new FirstScrollListener() {

            @Override
            public void onShow() {
                mToolbar.animate().alpha(1.0f).setDuration(300);
            }

            @Override
            public void onHide() {
                mToolbar.animate().alpha(0f).setDuration(300);
            }
        });
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item:" + i);
        }
        return list;
    }

    private void initToolBar() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(Color.WHITE);
    }
}
