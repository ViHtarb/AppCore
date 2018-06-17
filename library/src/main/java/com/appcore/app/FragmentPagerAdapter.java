package com.appcore.app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.appcore.fragments.PageFragment;

/**
 * Base implementation of {@link android.support.v4.app.FragmentPagerAdapter} with
 * implemented {@link #getPageTitle(int)} method for fragments that are
 * an {@link PageFragment} interface implementation.
 */
public abstract class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private final Context mContext;

    public FragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = getItem(position);
        if (fragment instanceof PageFragment) {
            return ((PageFragment) fragment).getTitle(mContext);
        }
        return null;
    }

    public Context getContext() {
        return mContext;
    }
}