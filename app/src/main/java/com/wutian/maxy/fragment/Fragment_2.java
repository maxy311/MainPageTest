package com.wutian.maxy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wutian.maxy.R;

public class Fragment_2 extends BaseFragment {

    public static Fragment getInstance() {
        Fragment fragment = new Fragment_2();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        View view = getView();
        if (view == null)
            return;

        TextView textView = (TextView) view.findViewById(R.id.fragment);
        textView.setText("I am second");
    }

    @Override
    protected String getName() {
        return "Fragment_2";
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_test_2;
    }

    @Override
    public void loadData(boolean isForce) {
        if (mHasLoaded && !isForce)
            return;
        mHasLoaded = true;
        Log.e("wwwwwwwwww",getName() +  "    loadData  ");
    }
}
