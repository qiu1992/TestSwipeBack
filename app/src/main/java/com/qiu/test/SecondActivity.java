package com.qiu.test;

import android.os.Bundle;
import android.util.Log;

import com.qiu.swipeback.SwipeBackActivity;

public class SecondActivity extends SwipeBackActivity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);
        Log.d ("qiuqiu", "onCreate: SecondActivity");
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
