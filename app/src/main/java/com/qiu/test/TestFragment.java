package com.qiu.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-9-22.
 */

public class TestFragment extends Fragment
{
    public int position = -1;

    public static TestFragment getInstance (Bundle bundle)
    {
        TestFragment fragment = new TestFragment ();
        fragment.setArguments (bundle);
        return fragment;
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        position = getArguments ().getInt ("position");
        Log.d ("quiqiu", "onCreate: " + position);
    }

    @Override
    public void onResume ()
    {
        super.onResume ();
        Log.d ("quiqiu", "onResume: " + position + this.toString ());
    }

    @Override
    public void onPause ()
    {
        super.onPause ();
        Log.d ("quiqiu", "onPause: " + position);
    }

    @Override
    public void onStop ()
    {
        super.onStop ();
        Log.d ("quiqiu", "onStop: " + position);
    }

    @Override
    public void onDestroy ()
    {
        super.onDestroy ();
        Log.d ("quiqiu", "onDestroy: " + position);
    }

    @Override
    public void onDetach ()
    {
        super.onDetach ();
        Log.d ("quiqiu", "onDetach: " + position);
    }

    @Override
    public void setUserVisibleHint (boolean isVisibleToUser)
    {
        super.setUserVisibleHint (isVisibleToUser);
        Log.d ("quiqiu", "setUserVisibleHint: " + position + isVisibleToUser + this.toString ());
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View layout = inflater.inflate (R.layout.fragment_test,container,false);
        layout.setPadding (0,getStatusBarHeight (getActivity ()),0,0);
        TextView textView = (TextView) layout.findViewById (R.id.test_tv);
        textView.setText ("这是第：" + position + "页");
        textView.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick (View v)
            {
                startActivity (new Intent (getActivity (), SecondActivity.class));
            }
        });

        ViewPager childViewpager = (ViewPager) layout.findViewById (R.id.child_viewpager);
        TestPagerAdapter2 testAdapter = new TestPagerAdapter2 (getChildFragmentManager ());
        testAdapter.setParentPosition (position);
        childViewpager.setAdapter (testAdapter);
        return layout;
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
