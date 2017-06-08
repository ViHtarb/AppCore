package com.appcore.app;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.appcore.fragments.PageFragment;

/**
 * Base implementation of {@link android.support.v4.app.FragmentStatePagerAdapter} with
 * implemented {@link #getPageTitle(int)} method for fragments that are
 * an {@link PageFragment} interface implementation.
 */
public abstract class FragmentStatePagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

    private final Context mContext;

    public FragmentStatePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = getItem(position);
        if (fragment instanceof PageFragment) {
            return mContext.getString(((PageFragment) fragment).getTitle());
        }
        return null;
    }

    public Context getContext() {
        return mContext;
    }
}