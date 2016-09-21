/**
 * 文件名：DisplayUtil.java
 * <p>
 * 版本信息：
 * 日期：2013-12-17
 * Copyright (C) 2013 深圳市建乔无线信息技术有限公司
 * 版权所有
 */

package com.qiu.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 此类描述的是： [用一句话描述这个类什么作用]
 *
 * @author: [JimmyZhang]
 * @CreateDate: [2013-12-17 下午7:48:06]
 * @UpdateUser: [JimmyZhang]
 * @UpdateDate: [2013-12-17 下午7:48:06]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0.0]
 */

public class DisplayUtil
{

    /**
     *
     * 此方法描述的是：   获得屏幕宽度
     * @author:JimmyZhang
     * @since: 2013-12-17 下午7:50:54
     * @param activity
     * @return
     * @return int
     */
    public static int getWidthPixel (Activity activity)
    {
        DisplayMetrics dm = new DisplayMetrics ();
        activity.getWindowManager ().getDefaultDisplay ().getMetrics (dm);
        return dm.widthPixels;
    }

    /**
     *
     * 此方法描述的是：   获得屏幕高度
     * @author:JimmyZhang
     * @since: 2013-12-17 下午7:51:01
     * @param activity
     * @return
     * @return int
     */
    public static int getHeightPixel (Activity activity)
    {
        DisplayMetrics dm = new DisplayMetrics ();
        activity.getWindowManager ().getDefaultDisplay ().getMetrics (dm);
        return dm.heightPixels;
    }

    /**
     *
     * 此方法描述的是：根据屏幕适配搜索框的宽度
     * @author:JimmyZhang
     * @since: 2013-12-17 下午7:55:42
     * @param view
     * @param activity
     * @return void
     */
    public static void setViewWidth (LinearLayout view, Activity activity)
    {
        int widthPixel = getWidthPixel (activity);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams ();
        params.width = widthPixel * 2 / 3;
        view.setLayoutParams (params);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */
    public static int dip2px (Context context, float dpValue)
    {
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */
    public static int px2dip (Context context, float pxValue)
    {
        final float scale = context.getResources ().getDisplayMetrics ().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp (Context context, float pxValue)
    {
        final float fontScale = context.getResources ().getDisplayMetrics ().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变 
     *
     * @param spValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity） 
     * @return
     */
    public static int sp2px (Context context, float spValue)
    {
        final float fontScale = context.getResources ().getDisplayMetrics ().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 根据resid获得一个drawable
     * @param resId
     * @param context
     * @return
     */
    public static Drawable getDrawable (int resId, Context context)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            return context.getResources ().getDrawable (resId, context.getTheme ());
        }
        else
        {
            return context.getResources ().getDrawable (resId);
        }
    }
}
