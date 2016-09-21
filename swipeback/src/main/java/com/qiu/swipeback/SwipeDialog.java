package com.qiu.swipeback;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

public class SwipeDialog extends Dialog
{
    private SwipeWindowHelper mSwipeWindowHelper;

    public SwipeDialog (Context context)
    {
        super (context);
    }

    public SwipeDialog (Context context, int themeResId)
    {
        super (context, themeResId);
    }


    @Override
    public boolean dispatchTouchEvent (MotionEvent ev)
    {
        if (mSwipeWindowHelper == null)
        {
            mSwipeWindowHelper = new SwipeWindowHelper (getWindow ());
        }
        return mSwipeWindowHelper.processTouchEvent (ev) || super.dispatchTouchEvent (ev);
    }
}
