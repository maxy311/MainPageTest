package com.wutian.maxy.viewpager;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wutian.maxy.R;

public class PagerIndicator extends LinearLayout {
    private static final String TAG = "UI.PagerIndicator";
    private Context mContext;

    public interface OnIndicatorClickListener {
        public void onIndicatorClick(View view, int position);
    }

    private int mCurrentIndex = 0;
    private OnIndicatorClickListener mIndicatorClickListener;

    public PagerIndicator(Context context) {
        super(context);
        mContext = context;
    }

    public PagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentItem(mCurrentIndex);
    }

    public void setOnIndicatorClickListener(OnIndicatorClickListener listener) {
        mIndicatorClickListener = listener;
    }

    public void addIndicator(int iconResId, int labelResId) {
        View view = View.inflate(getContext(), R.layout.main_pager_indicator_item_view, null);

        ImageView icon = (ImageView)view.findViewById(R.id.icon);
        icon.setImageResource(iconResId);

        TextView label = (TextView)view.findViewById(R.id.label);
        label.setText(labelResId);

        final int position = getChildCount();
        LayoutParams params = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
        addView(view, params);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndicatorClickListener != null)
                    mIndicatorClickListener.onIndicatorClick(v, position);
            }
        });
    }

    public void setCurrentItem(int index) {
        mCurrentIndex = index;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view == null)
                continue;

            if (i == index)
                view.setSelected(true);
            else
                view.setSelected(false);
        }
    }
}
