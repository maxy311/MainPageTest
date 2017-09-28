package com.wutian.maxy.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class HackyViewPager extends ViewPager {

    private boolean mIsLocked = true;

    public HackyViewPager(Context context) {
        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!mIsLocked)
            return super.onInterceptTouchEvent(event);

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!mIsLocked)
            return super.onTouchEvent(event);

        return false;
    }

    public void setIsLocked(boolean isLocked) {
        mIsLocked = isLocked;
    }

    public boolean getIsLocked() {
        return mIsLocked;
    }
}
