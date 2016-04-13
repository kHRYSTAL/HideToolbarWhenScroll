package me.khrystal.htb;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.adapter.FirstAdapter;
import me.khrystal.third_widget.ObservableRecyclerView;
import me.khrystal.third_widget.ObservableScrollViewCallbacks;
import me.khrystal.third_widget.ScrollState;

public class ThridActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    private Toolbar mToolbar;
    private ObservableRecyclerView mRecyclerView;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        supportActionBar = getSupportActionBar();


        mRecyclerView = (ObservableRecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setScrollViewCallbacks(this);
        mRecyclerView.setAdapter(new FirstAdapter(getList()));
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item:" + i);
        }
        return list;
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (supportActionBar==null)
            return;
        if (scrollState == ScrollState.UP){
            if (supportActionBar.isShowing())
                supportActionBar.hide();
        }else if (scrollState == ScrollState.DOWN)
            if (!supportActionBar.isShowing())
                supportActionBar.show();
    }
}
