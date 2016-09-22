package com.qiu.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-9-22.
 */

public class TestPagerAdapter2 extends FragmentPagerAdapter
{
    private List<Fragment> fragmentList = new ArrayList<> ();
    private int parentPosition = -1;

    public TestPagerAdapter2 (FragmentManager fm)
    {
        super (fm);
    }

    @Override
    public Fragment getItem (int position)
    {
//        if (fragmentList.size () == 0 || fragmentList.get (position)==null || fragmentList.get (position).isDetached ())
//        {
            Bundle bundle = new Bundle ();
            bundle.putInt ("position",position);
            bundle.putInt ("parentPosition",parentPosition);
            TestFragment2 fragment = TestFragment2.getInstance (bundle);
//            fragmentList.add (position,fragment);
//        }

        return fragment;
//        return fragmentList.get (position);
    }

    public void setParentPosition (int parentPosition)
    {
        this.parentPosition = parentPosition;
    }

    @Override
    public int getCount ()
    {
        return 3;
    }
}
