package com.appcore.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.appcore.R;
import com.appcore.R2;

import butterknife.Bind;

/**
 * Created by Viнt@rь on 18.04.2016
 */
public abstract class PagerFragment extends Fragment implements ViewPager.OnPageChangeListener {

    @Nullable
    @Bind(R2.id.tab_layout)
    protected TabLayout mTabLayout;

    @Bind(R2.id.view_pager)
    protected ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_pager;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager.setAdapter(getAdapter());
        mViewPager.addOnPageChangeListener(this);

        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof FragmentPagerAdapter || adapter instanceof FragmentStatePagerAdapter) {
            android.support.v4.app.Fragment fragment;
            if (adapter instanceof FragmentPagerAdapter) {
                fragment = ((FragmentPagerAdapter) adapter).getItem(position);
            } else {
                fragment = ((FragmentStatePagerAdapter) adapter).getItem(position);
            }

            if (fragment != null && fragment instanceof PageFragment) {
                ((PageFragment) fragment).onSelected();
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public abstract PagerAdapter getAdapter();
}
