package com.appcore.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.R;

/**
 * Created by Viнt@rь on 18.04.2016
 */
public abstract class PagerFragment extends Fragment {

    @Nullable
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (view != null) {
            mTabLayout = view.findViewById(R.id.tab_layout);
            mViewPager = view.findViewById(R.id.view_pager);

            if (mViewPager != null) {
                mViewPager.setAdapter(getAdapter());
                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        PagerFragment.this.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        PagerFragment.this.onPageSelected(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        PagerFragment.this.onPageScrollStateChanged(state);
                    }
                });
            } else {
                throw new IllegalStateException("Required view 'R.id.view_pager' with ID " + R.id.view_pager + " for field 'mViewPager' was not found.");
            }

            if (mTabLayout != null) {
                mTabLayout.setupWithViewPager(mViewPager);
            }
        }

        return view;
    }

    protected void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    protected void onPageSelected(int position) {
        PagerAdapter adapter = getAdapter();
        if (adapter instanceof FragmentPagerAdapter || adapter instanceof FragmentStatePagerAdapter) {
            android.support.v4.app.Fragment fragment;
            if (adapter instanceof FragmentPagerAdapter) {
                fragment = ((FragmentPagerAdapter) adapter).getItem(position);
            } else {
                fragment = ((FragmentStatePagerAdapter) adapter).getItem(position);
            }

            if (fragment instanceof PageFragment) {
                ((PageFragment) fragment).onSelected();
            }
        }
    }

    protected void onPageScrollStateChanged(int state) {

    }

    protected abstract PagerAdapter getAdapter();
}