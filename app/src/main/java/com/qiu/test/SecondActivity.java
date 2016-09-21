package com.qiu.test;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.qiu.swipeback.SwipeBackActivity;

import qiu.niorgai.StatusBarCompat;

public class SecondActivity extends SwipeBackActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);

//        StatusBarCompat.translucentStatusBar(this, true);
        Log.d ("qiuqiu", "onCreate: SecondActivity");
        StatusBarCompat.setStatusBarColor (this, Color.YELLOW);
    }

    @Override
    protected void onPause ()
    {
        super.onPause ();
        Log.d ("qiuqiu", "onPause: SecondActivity");
    }

    @Override
    protected void onStop ()
    {
        super.onStop ();
        Log.d ("qiuqiu", "onStop: SecondActivity");
    }

    @Override
    protected void onDestroy ()
    {
        super.onDestroy ();
        Log.d ("qiuqiu", "onDestroy: SecondActivity");
    }
}
