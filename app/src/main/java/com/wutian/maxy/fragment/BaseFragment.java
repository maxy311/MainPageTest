package com.wutian.maxy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    protected boolean mStubInflated = false;
    protected boolean mIsVisibleToUser = false;
    protected boolean mHasLoaded = false;

    private Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        Log.e("wwwwwwww", getName() + "  onAttach ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("wwwwwwww", getName() + "  onViewCreated ");
        checkAndInitView();
    }

    public void checkAndInitView() {
        View view = getView();
        if (view == null)
            return;

        if (!mIsVisibleToUser)
            return;

        if (mStubInflated)
            return;
        mStubInflated = true;

        Log.e("wwwwwwww", getName() + "    checkAndInitView");
        initView();

        loadData(true);
    }

    public abstract void loadData(boolean isForce);

    protected abstract void initView();

    protected abstract String getName();

    protected abstract int getLayoutResId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mIsVisibleToUser = isVisibleToUser;
        Log.e("wwwwwwwww", getName() + "   setUserVisibleHint   == " + isVisibleToUser);
        if (mIsVisibleToUser)
            checkAndInitView();
    }


}
