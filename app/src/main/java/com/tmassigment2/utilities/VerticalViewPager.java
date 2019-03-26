package com.tmassigment2.utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;

/**
 * Created by Sumedha Vats on 26-03-2019.
 */
public class VerticalViewPager extends ViewPager {
    public VerticalViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public void init() {
        setPageTransformer(true, new ViewPagerTransform());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private MotionEvent SwapXY(MotionEvent event) {
        float x = getWidth();
        float y = getHeight();

        float newX = (event.getY() / y) * y;
        float newY = (event.getX() / x) * x;

        event.setLocation(newX, newY);
        return event;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(SwapXY(ev));
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = super.onInterceptTouchEvent(SwapXY(ev));
        SwapXY(ev);
        return intercept;
    }

    public class ViewPagerTransform implements ViewPager.PageTransformer {
        public static final float MIN_SCALE = 0.65f;

        @Override
        public void transformPage(@NonNull View view, float position) {
            if (position < -1) {
                view.setAlpha(0);
            } else if (position <= 1) {
                view.setAlpha(1);
                view.setTranslationX(view.getWidth() * -position);
                view.setTranslationY(view.getHeight() * position);
                view.setScaleX(1);
                view.setScaleY(1);
            }else if(position<1){
                view.setAlpha(1-position);
                view.setTranslationX(view.getWidth()* -position);
                view.setTranslationY(0);
                float scaleFactor= MIN_SCALE+ (1-MIN_SCALE)*(1-Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            }else if(position>1){
                view.setAlpha(0);
            }
        }
    }

}
