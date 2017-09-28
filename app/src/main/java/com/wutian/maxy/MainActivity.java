package com.wutian.maxy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.wutian.maxy.viewpager.MainView;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainView mainView = (MainView) findViewById(R.id.main_view);
        mainView.initView(this);
    }
}
