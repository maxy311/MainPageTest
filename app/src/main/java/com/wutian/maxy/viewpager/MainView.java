package com.wutian.maxy.viewpager;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.wutian.maxy.R;
import com.wutian.maxy.fragment.BaseFragment;
import com.wutian.maxy.fragment.Fragment_1;
import com.wutian.maxy.fragment.Fragment_2;
import com.wutian.maxy.fragment.Fragment_3;
import com.wutian.maxy.fragment.Fragment_4;

import java.util.ArrayList;
import java.util.List;

public class MainView extends FrameLayout {
    private Context mContext;

    private ViewPager mViewPager;
    private PagerIndicator mPagerIndicator;
    private FragmentViewPagerAdapter mPagerAdapter;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private static final int MAX_PAGE_NUM = 4;
    private int mLastIndex = -1;
    public MainView(@NonNull Context context) {
        super(context);
    }

    public MainView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MainView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Context context) {
        mContext = context;
        View view = View.inflate(mContext, R.layout.main_pager_view, this);

        mPagerIndicator = (PagerIndicator)view.findViewById(R.id.indicator);
        mPagerIndicator.setOnIndicatorClickListener(mIndicatorClickListener);

        mPagerAdapter = new FragmentViewPagerAdapter(((FragmentActivity)getContext()).getSupportFragmentManager(), mFragmentList);
        mViewPager = (ViewPager)view.findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(MAX_PAGE_NUM);
        mViewPager.setAdapter(mPagerAdapter);

        initData();
    }


    public void initData() {
        Fragment fragment_1 = Fragment_1.getInstance();
        Fragment fragment_2 = Fragment_2.getInstance();
        Fragment fragment_3 = Fragment_3.getInstance();
        Fragment fragment_4 = Fragment_4.getInstance();

        mFragmentList.add(fragment_1);
        mFragmentList.add(fragment_2);
        mFragmentList.add(fragment_3);
        mFragmentList.add(fragment_4);

        mPagerIndicator.addIndicator(R.drawable.share_zone_normal, R.string.fragment_name_1);
        mPagerIndicator.addIndicator(R.drawable.share_zone_normal, R.string.fragment_name_2);
        mPagerIndicator.addIndicator(R.drawable.share_zone_normal, R.string.fragment_name_3);
        mPagerIndicator.addIndicator(R.drawable.share_zone_normal, R.string.fragment_name_4);

        mPagerAdapter.notifyDataSetChanged();

        switchPage(0);
    }

    private PagerIndicator.OnIndicatorClickListener mIndicatorClickListener = new PagerIndicator.OnIndicatorClickListener() {
        @Override
        public void onIndicatorClick(View view, int position) {
            switchPage(position);
        }
    };

    public void switchPage(int index) {
        mViewPager.setCurrentItem(index, false);
        mPagerIndicator.setCurrentItem(index);

        if (mLastIndex == index)
            ((BaseFragment) mFragmentList.get(index)).loadData(true);

        mLastIndex = index;
    }
}
