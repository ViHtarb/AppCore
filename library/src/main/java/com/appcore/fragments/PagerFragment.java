package com.appcore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appcore.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Viнt@rь on 18.04.2016
 */
public abstract class PagerFragment extends Fragment {

    @Nullable
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;

    public PagerFragment() {
        super(R.layout.fragment_pager);
    }

    @ContentView
    public PagerFragment(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        if (view != null) {
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

            mTabLayout = view.findViewById(R.id.tab_layout);
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
            androidx.fragment.app.Fragment fragment;
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