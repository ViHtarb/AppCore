package com.appcore.fragments;

import android.os.Bundle;
import android.view.View;

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
 * Base implementation of {@link Fragment} with implemented binding
 * {@link TabLayout} and {@link ViewPager} to this fragment.
 *
 * <p>
 * Fragment already has layout {@link R.layout#fragment_pager} which
 * contains {@link TabLayout} with id {@link R.id#tab_layout}
 * and {@link ViewPager} with id {@link R.id#view_pager}.
 * </p>
 *
 * <p>
 * For implement custom layout your need override constructor with custom layout id
 * and this layout must contain {@link ViewPager} with id {@link R.id#view_pager}
 * {@code android:id="id/view_pager"}.
 * </p>
 *
 * <p>
 * If you want implement custom layout with {@link TabLayout} then this
 * layout must contain {@link TabLayout} with id {@link R.id#tab_layout}
 * {@code android:id="id/tab_layout"}.
 * </p>
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
            throw new IllegalStateException("appcore:PagerFragment: Required view 'R.id.view_pager' with ID " + R.id.view_pager + " for field 'mViewPager' was not found.");
        }

        mTabLayout = view.findViewById(R.id.tab_layout);
        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(mViewPager);
        }
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