package com.neocean.app.neoceansoftdensityutils;

import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by cxy on 2016/11/14.
 */

public class DensityUtil {


    /**
     * 获取屏幕宽高，单位px * @param context * @return
     */
    public static Point getScreenMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        return new Point(screenWidth, screenHeight);
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * view宽高
     * @param view
     * @param handler
     */
    public static void getViewMH(final View view, final Handler handler) {
        final int[] mWidth = {0};
        final int[] mHeight = new int[1];
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mWidth[0] = view.getWidth();
                int measuredHeight = view.getMeasuredHeight();
                mHeight[0] = view.getHeight();
                Message message = handler.obtainMessage();
                message.obj = new Point(mWidth[0], mHeight[0]);
                handler.sendMessage(message);
            }
        });

    }

}