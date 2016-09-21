package com.qiu.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qiu.swipeback.SwipeBackActivity;

import qiu.niorgai.StatusBarCompat;
import qiu.niorgai.StatusBarCompatLollipop;

public class MainActivity extends SwipeBackActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

//        StatusBarCompat.translucentStatusBar(this, true);
        StatusBarCompat.setStatusBarColor (this,Color.RED);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

//
//        BadgeItem numberBadgeItem = new BadgeItem()
//                .setBorderWidth(4)
//                .setBackgroundColorResource(Color.GREEN)
//                .setText("fdsf")
//                .setHideOnSelect(false);


//        BadgeItem numberBadgeItem = new BadgeItem()
//                .setBorderWidth(4)
//                .setBackgroundColorResource(R.color.colorPrimaryDark)
//                .setText("" + 1)
//                .setHideOnSelect(false);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV"))
                .initialise();

//        bottomNavigationBar.setAutoHideEnabled (false);
//        bottomNavigationBar
//                .setMode(BottomNavigationBar.MODE_FIXED);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        bottomNavigationBar.setBackgroundResource (R.color.test);

//        fullScreenContentView ();
//        StatusBarCompatLollipop.translucentStatusBar (this,true);
//        StatusBarCompatLollipop.setStatusBarColor (this,Color.GREEN);
//        //设置状态栏的颜色
//        StatusBarCompat.setStatusBarColor(this, getResources ().getColor (R.color.colorPrimary));
//        //透明状态栏
//        StatusBarCompat.translucentStatusBar(this);
//        //SDK >= 21时, 取消状态栏的阴影
//        StatusBarCompat.translucentStatusBar(this, true);
//        //为 CollapsingToolbarLayout 设置颜色
//        StatusBarCompat.setStatusBarColorForCollapsingToolbar(this,getResources ().getColor (R.color.colorPrimary));

//        Window window = getWindow();
//
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        if (true) {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarColor(Color.RED);
//            //隐藏状态栏的阴影window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        } else {
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//        }
//
//        ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
//        View mChildView = mContentView.getChildAt(0);
//        if (mChildView != null) {
//            ViewCompat.setOnApplyWindowInsetsListener(mChildView, new OnApplyWindowInsetsListener () {
//                @Override
//                public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
//                    return insets;
//                }
//            });
//            ViewCompat.setFitsSystemWindows(mChildView, false);
//            ViewCompat.requestApplyInsets(mChildView);
//
//        }

        Log.d ("qiuqiu", "onCreate: MainActivity");
    }

    @Override
    protected void onPause ()
    {
        super.onPause ();
        Log.d ("qiuqiu", "onPause: MainActivity");
    }

    @Override
    protected void onStop ()
    {
        super.onStop ();
        Log.d ("qiuqiu", "onStop: MainActivity");
    }

    @Override
    protected void onDestroy ()
    {
        super.onDestroy ();
        Log.d ("qiuqiu", "onDestroy: MainActivity");
    }

    public void startActivity (View view)
    {
        startActivity (new Intent (this, SecondActivity.class));
    }

    /**
     * 布局融入状态栏
     */
    public void fullScreenContentView ()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow ();
            //设置透明状态栏,这样才能让 ContentView 向上
            window.addFlags (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor (getResources ().getColor (R.color.colorPrimary));
            ViewGroup mContentView = (ViewGroup) findViewById (Window.ID_ANDROID_CONTENT);

            // 这里的意思是：人为添加一个与状态栏同样高度的view,
            View view = new View (this);
//            view.setLayoutParams (new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px (this, 20.0f)));
            view.setLayoutParams (new LinearLayout.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight (this)));
            view.setBackgroundColor (Color.RED);
            mContentView.addView (view, 0);

            // 测试发现，上面添加的view没有效果，于是设置了margin
            View secondView = mContentView.getChildAt (1);
            FrameLayout.LayoutParams secondParams = (FrameLayout.LayoutParams) secondView.getLayoutParams ();
            secondParams.setMargins (0, getStatusBarHeight (this), 0, 0);

            View mChildView = mContentView.getChildAt (0);
            if (mChildView != null)
            {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 使其不为系统 View 预留空间.
                ViewCompat.setFitsSystemWindows (mChildView, false);
            }
        }
    }

    public static int getStatusBarHeight (Context context)
    {
        int height = getStatusBarHeight1 (context);
        return height <= 0 ? DisplayUtil.dip2px (context, 20.0f) : height;
    }

    /**
     * 获取状态栏高度。界面没有显示也可以拿到
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight1 (Context context)
    {
        int result = 0;
        int resourceId = context.getResources ().getIdentifier ("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources ().getDimensionPixelSize (resourceId);
        }
        return result;
    }

}
