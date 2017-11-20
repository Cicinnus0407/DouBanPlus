package com.cicinnus.corelib.utils;

import android.content.Context;
import android.util.DisplayMetrics;


/**
 * UI相关
 *
 * @author Cicinnus
 */

public class UiUtils {


    /**
     * 反射获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    /**
     * 动态获取屏幕的宽度
     *
     * @param context context
     * @return 屏幕宽度像素值
     */
    public static int getDeviceWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    /**
     * 动态获取屏幕的高度
     *
     * @param context context
     * @return 屏幕高度像素值
     */
    public static int getDeviceHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    /**
     * 将dp转为px
     *
     * @param context context
     * @param dpValue dp值
     * @return 像素值
     */
    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
