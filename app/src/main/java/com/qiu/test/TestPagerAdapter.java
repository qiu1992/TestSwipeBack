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

public class TestPagerAdapter extends FragmentPagerAdapter
{
    private List<Fragment> fragmentList = new ArrayList<> ();

    public TestPagerAdapter (FragmentManager fm)
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
            TestFragment fragment = TestFragment.getInstance (bundle);
//            fragmentList.add (position,fragment);
//        }

        return fragment;
//        return fragmentList.get (position);
    }

    @Override
    public int getCount ()
    {
        return 4;
    }
}
