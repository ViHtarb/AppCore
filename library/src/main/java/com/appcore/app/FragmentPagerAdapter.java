package com.appcore.app;

import android.content.Context;

import com.appcore.fragments.PageFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Base implementation of {@link androidx.fragment.app.FragmentPagerAdapter} with
 * implemented {@link #getPageTitle(int)} method for fragments that are
 * an {@link PageFragment} interface implementation.
 */
public abstract class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private final Context mContext;

    public FragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm, RESUME_ONLY_CURRENT_FRAGMENT);
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