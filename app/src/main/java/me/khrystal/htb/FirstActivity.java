package me.khrystal.htb;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.adapter.FirstAdapter;
import me.khrystal.listener.FirstScrollListener;

public class FirstActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageButton mFabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initToolBar();
        initView();
    }

    private void initView() {
        mFabButton = (ImageButton)findViewById(R.id.fabButton);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirstAdapter adapter = new FirstAdapter(getList());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new FirstScrollListener() {
            @Override
            public void onShow() {
                mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
                mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onHide() {
                mToolbar.animate().translationY(-mToolbar.getHeight())
                        .setInterpolator(new AccelerateInterpolator(2));
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)mFabButton.getLayoutParams();
                int fabBottomMargin = lp.bottomMargin;
                mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin)
                        .setInterpolator(new AccelerateInterpolator(2)).start();
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
