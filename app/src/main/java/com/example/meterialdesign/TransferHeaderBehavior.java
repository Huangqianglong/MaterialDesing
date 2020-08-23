package com.example.meterialdesign;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class TransferHeaderBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    /**
     * 处于中心时候原始X轴
     */
    private int mOriginalHeaderX = 0;
    /**
     * 处于中心时候原始Y轴
     */
    private int mOriginalHeaderY = 0;


    private CollapsingToolbarLayout collapsingToolbarLayout;

    public TransferHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {
        // 计算X轴坐标
        if (mOriginalHeaderX == 0) {
            this.mOriginalHeaderX = child.getWidth() / 2 - dependency.getWidth() / 2;
        }
        // 计算Y轴坐标
        if (mOriginalHeaderY == 0) {
            mOriginalHeaderY = dependency.getHeight() - child.getHeight();
        }
        if (null == collapsingToolbarLayout) {
            collapsingToolbarLayout = parent.findViewById(R.id.ct_container);
        }
        //X轴百分比
        float mPercentX = dependency.getY() / mOriginalHeaderX;
        if (mPercentX >= 1) {
            mPercentX = 1;
        }
        //Y轴百分比
        float mPercentY = dependency.getY() / mOriginalHeaderY;
        if (mPercentY >= 1) {
            mPercentY = 1;
        }

        float x = mOriginalHeaderX/*403*/ - mOriginalHeaderX * mPercentX/*-1.228287*/;
//        if (x <= child.getWidth()) {
//            x = child.getWidth();
//        }
        // TODO 头像的放大和缩小没做
        Log.d("hql", "x轴百分比：" + mPercentX + ">中点x:" + mOriginalHeaderX + ">x轴长度>" + child.getWidth() + "  dependency长度：" + dependency.getWidth()
                + "  按比例偏移：" + x

                + ">>y轴百分比:" + mPercentY
                + ">>dependency getHeight :" + dependency.getHeight()
                + ">>child getHeight :" + child.getHeight()
                + ">>dependency getY :" + dependency.getY()
        );

        Log.d("hql", ">>>>>>（x:" + x + ",y:" + (mOriginalHeaderY - mOriginalHeaderY * mPercentY) + ")   mOriginalHeaderY:"
                + mOriginalHeaderY
                + "   :y>>" + dependency.getY()
        );
        child.setX(Math.abs(x));
        child.setY(mOriginalHeaderY - mOriginalHeaderY * mPercentY);
        child.setAlpha(mPercentY);
        dependency.setAlpha(1 - mPercentY);
        collapsingToolbarLayout.setAlpha(1.5f - mPercentY);

//        child.setX(0);
//        child.setY(0);
        return true;
    }
}
